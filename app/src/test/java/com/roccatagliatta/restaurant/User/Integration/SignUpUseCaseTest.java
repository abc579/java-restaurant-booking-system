package com.roccatagliatta.restaurant.User.Integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.roccatagliatta.restaurant.PasswordEncryptor.PasswordEncryptor;
import com.roccatagliatta.restaurant.User.Domain.Value.*;
import com.roccatagliatta.restaurant.User.Domain.User;
import com.roccatagliatta.restaurant.User.Application.UseCase.Exception.SignUpUseCaseException;
import com.roccatagliatta.restaurant.User.Domain.Persistence.UserRepository;
import com.roccatagliatta.restaurant.User.Application.UseCase.SignUpUseCase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
final class SignUpUseCaseTest {

    @Autowired
    private PasswordEncryptor encryptor;

    @Autowired
    private SignUpUseCase useCase;

    @Autowired
    private UserRepository repository;

    @Test
    void exception_is_thrown_when_user_email_already_exists_in_database() throws Exception {
        UserId id = new UserId("ad2296ae-c0cb-412e-bb63-e2b3c1d3470c");
        UserName name = new UserName("liwakura");
        UserEmail email = new UserEmail("liwakura@wired.cz");
        UserPassword password = UserPassword.fromPlain("haha123Unloved", encryptor);
        UserType type = UserType.MANAGER;

        User user = new User(id, name, email, password, type);

        useCase.run(user);

        SignUpUseCaseException ex = assertThrows(SignUpUseCaseException.class, () -> {
            User invalidUser = new User(id, new UserName("shit"), email, password, type);
            useCase.run(invalidUser);
        });

        assertEquals(SignUpUseCaseException.EMAIL_EXISTS, ex.errorCode);
    }

    @Test
    void exception_is_thrown_when_username_already_exists_in_database() throws Exception {
        UserId id = new UserId("ad2296ae-c0cb-412e-bb63-e2b3c1d3470c");
        UserName name = new UserName("liwakura");
        UserEmail email = new UserEmail("liwakura@wired.cz");
        UserPassword password = UserPassword.fromPlain("haha123Unloved", encryptor);
        UserType type = UserType.MANAGER;

        User user = new User(id, name, email, password, type);

        useCase.run(user);

        SignUpUseCaseException ex = assertThrows(SignUpUseCaseException.class, () -> {
            User invalidUser = new User(id, name, new UserEmail("test@test.com"), password, type);
            useCase.run(invalidUser);
        });

        assertEquals(SignUpUseCaseException.USERNAME_EXISTS, ex.errorCode);
    }

    @Test
    void user_is_created_and_database_returns_data_successfully() throws Exception {
        UserId id = new UserId("ad2296ae-c0cb-412e-bb63-e2b3c1d3470c");
        UserName name = new UserName("liwakura");
        UserEmail email = new UserEmail("liwakura@wired.cz");
        UserPassword password = UserPassword.fromPlain("haha123Unloved", encryptor);
        UserType type = UserType.MANAGER;

        User user = new User(id, name, email, password, type);

        useCase.run(user);

        assertEquals(user, repository.findById(id).get());
        assertEquals(user, repository.findByEmail(email).get());
        assertEquals(user, repository.findByUsername(name).get());
    }
}
