package com.roccatagliatta.restaurant.User.Integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.jdbc.Sql;

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

@SpringJUnitConfig
@Sql("/Data_SignUpUseCaseTest.sql")
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
        final UserId id = new UserId("4f118fd8-c893-453b-83a8-abf73fc421c0");
        final UserName name = new UserName("liwakuraz");
        final UserEmail email = new UserEmail("liwakura@wired.cz");
        final UserPassword password = UserPassword.fromPlain("haha123Unloved", encryptor);
        final UserType type = UserType.MANAGER;
        final User duplicatedUserEmail = new User(id, name, email, password, type);

        SignUpUseCaseException ex = assertThrows(SignUpUseCaseException.class, () -> {
            useCase.run(duplicatedUserEmail);
        });

        assertEquals(SignUpUseCaseException.EMAIL_EXISTS, ex.errorCode);
    }

    @Test
    void exception_is_thrown_when_username_already_exists_in_database() throws Exception {
        final UserId id = new UserId("aba159af-b855-4feb-baf4-5e0c013c1159");
        final UserName name = new UserName("liwakura");
        final UserEmail email = new UserEmail("liwakura2@wired.cz");
        final UserPassword password = UserPassword.fromPlain("haha123Unloved", encryptor);
        final UserType type = UserType.MANAGER;
        final User duplicatedUserName = new User(id, name, email, password, type);

        SignUpUseCaseException ex = assertThrows(SignUpUseCaseException.class, () -> {
            useCase.run(duplicatedUserName);
        });

        assertEquals(SignUpUseCaseException.USERNAME_EXISTS, ex.errorCode);
    }

    @Test
    void user_is_created_and_database_returns_data_successfully() throws Exception {
        final UserId id = new UserId("cb342476-1347-4a94-8786-9a6390dc5148");
        final UserName name = new UserName("liwakurax");
        final UserEmail email = new UserEmail("liwakuraf@wired.cz");
        final UserPassword password = UserPassword.fromPlain("haha123Unloved", encryptor);
        final UserType type = UserType.MANAGER;
        final User user = new User(id, name, email, password, type);

        useCase.run(user);

        assertEquals(user, repository.findById(id).get());
        assertEquals(user, repository.findByEmail(email).get());
        assertEquals(user, repository.findByUsername(name).get());
    }
}
