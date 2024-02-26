package com.roccatagliatta.restaurant.User.Unit.Domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.roccatagliatta.restaurant.PasswordEncryptor.PasswordEncryptor;
import com.roccatagliatta.restaurant.User.Domain.User;
import com.roccatagliatta.restaurant.User.Domain.Value.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class UserTest {

    @Mock
    private PasswordEncryptor encryptor;

    public void setup() {
        encryptor = Mockito.mock(PasswordEncryptor.class);
    }

    @Test
    void user_is_created_when_user_is_valid() {
        try {
            UserId id = new UserId("4e910d63-a2bd-4e53-92cc-282a04203588");
            UserName name = new UserName("liwakura");
            UserPassword password = UserPassword.fromPlain("hahaDumb123", encryptor);
            UserEmail email = new UserEmail("testing@dotcom.com");
            UserType type = UserType.CUSTOMER;
            User validUser = new User(id, name, email, password, type);

            assertEquals(id.value(), validUser.id().value());
            assertEquals(name.value(), validUser.username().value());
            assertEquals(password.value(), validUser.password().value());
            assertEquals(email.value(), validUser.email().value());
            assertEquals(type.value(), validUser.type().value());
        } catch (final Exception ex) {
            assertTrue(false);
        }
    }

}
