package com.roccatagliatta.restaurant.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import com.roccatagliatta.restaurant.User.Persistence.UserRepository;
import com.roccatagliatta.restaurant.PasswordEncryptor.PasswordEncryptor;
import com.roccatagliatta.restaurant.User.Exceptions.SignUpUseCaseException;
import com.roccatagliatta.restaurant.User.Value.*;

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
    void repository_is_called_when_customer_is_valid() {
        // Mockito.when(encryptor.encrypt(any())).thenReturn("haha123Loser");

        try {
            UserId id = new UserId("0e6fae88-16c3-4a25-9a5e-0ef939804049");
            UserName name = new UserName("liwakura");
            UserPassword password = UserPassword.fromPlain("abc", encryptor);
            UserEmail email = new UserEmail("liwakura@test.com");
            User user = new User(id, name, email, password, UserType.CUSTOMER);

            useCase.run(user);

            verify(repository, times(1)).save(any(User.class));
        } catch (final Exception ex) {

        }
    }

    @Test
    void throws_exception_when_user_email_already_exists() {
        // Mockito.when(encryptor.encrypt(any())).thenReturn("haha123Loser");

        try {
            User existingUser = new User(new UserId("0e6fae88-16c3-4a25-9a5e-0ef939804049"),
                    new UserName("liwakura"),
                    new UserEmail("liwakura@test.com"),
                    UserPassword.fromPlain("abc", encryptor),
                    UserType.CUSTOMER);

            Mockito.when(repository.findByEmail(any())).thenReturn(Optional.of(existingUser));

            SignUpUseCaseException ex = assertThrows(SignUpUseCaseException.class, () -> {
                useCase.run(existingUser);
            });

            assertEquals(ex.errorCode, SignUpUseCaseException.EMAIL_EXISTS);
        } catch (final Exception ex) {

        }
    }
}
