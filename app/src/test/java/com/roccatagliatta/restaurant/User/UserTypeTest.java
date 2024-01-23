package com.roccatagliatta.restaurant.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserTypeException;
import com.roccatagliatta.restaurant.User.Value.UserType;

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
}
