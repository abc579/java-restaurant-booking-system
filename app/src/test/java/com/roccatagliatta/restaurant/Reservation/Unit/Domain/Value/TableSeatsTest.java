package com.roccatagliatta.restaurant.Reservation.Domain.Unit.Value;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.roccatagliatta.restaurant.Reservation.Domain.Value.TableSeats;
import com.roccatagliatta.restaurant.Reservation.Domain.Value.Exception.InvalidTableSeats;

public final class TableSeatsTest {

    @Test
    void exception_is_thrown_with_invalid_seats() {
        final String[] invalid = {
            "ab",
            "-1",
            "0",
            "11"
        };

        for (final String i : invalid) {
            assertThrows(InvalidTableSeats.class, () -> { new TableSeats(i); });
        }
    }

    @Test
    void table_seats_are_created_when_seats_are_valid() throws InvalidTableSeats {
        final String[] valid = {
            "2",
            "3",
            "4",
            "10"
        };

        for (final String v : valid) {
            assertAll(() -> { new TableSeats(v); });
        }
    }
}
