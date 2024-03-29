package com.roccatagliatta.restaurant.User.Unit.Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import com.roccatagliatta.restaurant.User.Domain.Persistence.UserRepository;
import com.roccatagliatta.restaurant.PasswordEncryptor.PasswordEncryptor;
import com.roccatagliatta.restaurant.User.Application.UseCase.Exception.SignUpUseCaseException;
import com.roccatagliatta.restaurant.User.Domain.Value.*;
import com.roccatagliatta.restaurant.User.Domain.User;
import com.roccatagliatta.restaurant.User.Application.UseCase.SignUpUseCase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class SignUpUseCaseTest {

    @Mock
    private UserRepository repository;

    @Mock
    private PasswordEncryptor encryptor;

    @InjectMocks
    private SignUpUseCase useCase;

    public void setup() {
        repository = Mockito.mock(UserRepository.class);
        encryptor = Mockito.mock(PasswordEncryptor.class);
    }

    @Test
    void repository_is_called_when_customer_is_valid() throws Exception {
        Mockito.when(encryptor.encrypt(any(String.class))).thenReturn("asdsada");

        UserId id = new UserId("0e6fae88-16c3-4a25-9a5e-0ef939804049");
        UserName name = new UserName("liwakura");
        UserPassword password = UserPassword.fromPlain("eightMinDigits8", encryptor);
        UserEmail email = new UserEmail("liwakura@test.com");
        User user = new User(id, name, email, password, UserType.CUSTOMER);

        useCase.run(user);

        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    void throws_exception_when_user_email_already_exists() throws Exception {
        Mockito.when(encryptor.encrypt(any(String.class))).thenReturn("asdsada");

        User existingUser = new User(new UserId("0e6fae88-16c3-4a25-9a5e-0ef939804049"),
                                     new UserName("liwakura"),
                                     new UserEmail("liwakura@test.com"),
                                     UserPassword.fromPlain("eightMinDigits8", encryptor),
                                     UserType.CUSTOMER);

        Mockito.when(repository.findByEmail(any())).thenReturn(Optional.of(existingUser));

        SignUpUseCaseException ex = assertThrows(SignUpUseCaseException.class, () -> {
                useCase.run(existingUser);
        });

        assertEquals(SignUpUseCaseException.EMAIL_EXISTS, ex.errorCode);
    }
}
