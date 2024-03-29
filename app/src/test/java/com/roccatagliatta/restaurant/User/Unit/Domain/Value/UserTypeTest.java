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
        final String valid = "0";
        final UserType type = UserType.valueOf(Integer.valueOf(valid));

        assertEquals(type, UserType.CUSTOMER);
    }
}
