package com.roccatagliatta.restaurant.User.Unit.Domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.roccatagliatta.restaurant.User.Domain.Value.UserType;

import org.junit.jupiter.api.Test;

final class UserTypeTest {

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
