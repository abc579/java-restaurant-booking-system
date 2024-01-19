package com.roccatagliatta.restaurant.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

final class UserTest {

    @Test
    void user_is_created_when_user_is_valid() {
        try {
            UserId id = new UserId("4e910d63-a2bd-4e53-92cc-282a04203588");
            UserName name = new UserName("liwakura");
            UserPassword password = new UserPassword("hahaDumb123");
            UserEmail email = new UserEmail("testing@dotcom.com");
            UserType type = UserType.CUSTOMER;
            User validUser = new User(id, name, email, password, type);
            assertEquals(id.value(), validUser.id().value());
            assertEquals(name.value(), validUser.username().value());
            assertEquals(password.value(), validUser.password().value());
            assertEquals(email.value(), validUser.email().value());
            assertEquals(type.value(), validUser.type().value());
        } catch (final Exception ex) {
            // Unreachable.
        }
    }

}
