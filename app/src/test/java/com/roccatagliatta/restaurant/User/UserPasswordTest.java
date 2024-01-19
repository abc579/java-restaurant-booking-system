package com.roccatagliatta.restaurant.User;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserPasswordException;

import org.junit.jupiter.api.Test;

final class UserPasswordTest {

    @Test
    void exception_is_thrown_when_password_is_invalid() {
        final String[] invalidPasswords = { "abc", "test1", "final", null, "easyPassword" };

        for (final String invalid : invalidPasswords) {
            assertThrows(InvalidUserPasswordException.class, () -> {
                new UserPassword(invalid);
            });
        }
    }

    @Test
    void creates_valid_password_when_password_is_valid() {
        final String[] validPasswords = { "validPassword123", "LowerAndUpperPlusDigit1",
                "eightMinWithDigits8", "DontExceed32Chars", "DontPutWeirdChars1" };

        for (final String valid : validPasswords) {
            assertDoesNotThrow(() -> {
                final UserPassword validPassword = new UserPassword(valid);
                assertEquals(valid, validPassword.value());
            });
        }
    }
}
