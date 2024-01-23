package com.roccatagliatta.restaurant.User.Unit.Value;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserNameException;
import com.roccatagliatta.restaurant.User.Value.UserName;

import org.junit.jupiter.api.Test;

final class UserNameTest {

    @Test
    void exception_is_thrown_when_username_is_invalid() {
        final String[] invalidUserNames = { "a",
                "123",
                null,
                "asd@",
                "afb!",
                "!bcz·" };

        for (final String invalid : invalidUserNames) {
            assertThrows(InvalidUserNameException.class, () -> {
                new UserName(invalid);
            });
        }
    }

    @Test
    void creates_valid_username_when_username_is_valid() {
        final String[] validUserNames = {
                "testing",
                "admin",
                "hmason",
                "cmason",
                "liwakura"
        };

        for (final String valid : validUserNames) {
            assertDoesNotThrow(() -> {
                final UserName username = new UserName(valid);
                assertEquals(valid, username.value());
            });
        }
    }
}
