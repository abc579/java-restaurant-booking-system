package com.roccatagliatta.restaurant.User;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserEmailException;
import com.roccatagliatta.restaurant.User.Value.UserEmail;

import org.junit.jupiter.api.Test;

final class UserEmailTest {

    @Test
    void exception_is_thrown_when_email_is_invalid() {
        final String[] invalidEmails = { "abcd@", null, "crap", "@test", "@test.com", "bz.com" };

        for (final String invalid : invalidEmails) {
            assertThrows(InvalidUserEmailException.class, () -> {
                new UserEmail(invalid);
            });
        }
    }

    @Test
    void creates_valid_user_email_when_email_is_valid() {
        final String[] validEmails = { "abcd@test.com",
                "mary@silent-hill.com",
                "lain@wired.cz",
                "heather@maine.us" };

        for (final String valid : validEmails) {
            assertDoesNotThrow(() -> {
                final UserEmail email = new UserEmail(valid);
                assertEquals(valid, email.value());
            });
        }
    }
}
