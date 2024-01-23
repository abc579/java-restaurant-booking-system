package com.roccatagliatta.restaurant.User;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserIdException;
import com.roccatagliatta.restaurant.User.Value.UserId;

import org.junit.jupiter.api.Test;

final class UserIdTest {

    @Test
    void exception_is_thrown_when_id_is_invalid() {
        final String[] invalidUUIds = { "123",
                "1-",
                "41a315b6-dce9-4867-a93c-",
                "06d1e11dc254",
                "41a315b6-dce9-4867-06d1e11dc254-a93c",
                null };

        for (final String invalid : invalidUUIds) {
            assertThrows(InvalidUserIdException.class, () -> {
                new UserId(invalid);
            });
        }
    }

    @Test
    void creates_valid_uuid_with_valid_id() {
        final String[] validUUIds = { "41a315b6-dce9-4867-a93c-06d1e11dc254",
                "76f90ed0-314d-475c-bf4b-97586763e3e0",
                "e0ec45ff-0463-4b25-9709-e23dd508b822",
                "5e66ec4a-dc38-4a37-8ab8-7580270100bc"
        };

        for (final String valid : validUUIds) {
            assertDoesNotThrow(() -> {
                final UserId id = new UserId(valid);
                assertEquals(valid, id.value().toString());
            });
        }
    }
}
