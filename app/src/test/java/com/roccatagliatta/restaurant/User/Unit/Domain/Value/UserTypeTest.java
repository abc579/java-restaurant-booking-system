package com.roccatagliatta.restaurant.User.Unit.Domain.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.roccatagliatta.restaurant.User.Domain.Exception.InvalidUserTypeException;
import com.roccatagliatta.restaurant.User.Domain.Value.UserType;

import org.junit.jupiter.api.Test;

final class UserTypeTest {

    @Test
    void exception_is_thrown_with_invalid_user_type() {
        final String invalidType = "69";

        assertThrows(InvalidUserTypeException.class, () -> {
            UserType.valueOf(Integer.valueOf(invalidType));
        });
    }

    @Test
    void creates_user_type_with_valid_data() throws InvalidUserTypeException {
        final String invalidType = "0";
        final UserType type = UserType.valueOf(Integer.valueOf(invalidType));

        assertEquals(type, UserType.CUSTOMER);
    }

    @Test
    void user_type_method_exists_returns_true_when_type_exists() {
        assertTrue(UserType.exists("CUSTOMER"));
        assertTrue(UserType.exists("WAITER"));
        assertTrue(UserType.exists("MANAGER"));
    }

    @Test
    void user_type_method_exists_returns_false_when_type_does_not_exists() {
        assertFalse(UserType.exists("CUSTOMER1"));
        assertFalse(UserType.exists("WAITER1"));
        assertFalse(UserType.exists("MANAGER1"));
    }
}
