package com.roccatagliatta.restaurant.Reservation.Domain.Unit.Value;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.roccatagliatta.restaurant.Reservation.Domain.Value.TableId;
import com.roccatagliatta.restaurant.Reservation.Domain.Value.Exception.InvalidTableId;

public final class TableIdTest {

    @Test
    void exception_is_thrown_with_invalid_ids() {
        final String[] invalid = {
            "ab",
            "-1",
            "0"
        };

        for (final String i : invalid) {
            assertThrows(InvalidTableId.class, () -> { new TableId(i); });
        }
    }

    @Test
    void table_id_is_created_when_id_is_valid() throws InvalidTableId {
        final String[] valid = {
            "1",
            "10",
            "100",
            "123721"
        };

        for (final String v : valid) {
            assertAll(() -> { new TableId(v); });
        }
    }
}
