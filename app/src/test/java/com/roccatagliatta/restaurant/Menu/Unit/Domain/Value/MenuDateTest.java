package com.roccatagliatta.restaurant.Menu.Unit.Domain.Value;

import org.junit.jupiter.api.Test;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuDate;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

public final class MenuDateTest {

    @Test
    void exception_is_thrown_with_invalid_dates() {
        final int[][] invalidDates = {
            {1, -1, 1},
            {1, 1, -1},

            {1, 13, 1},
            {1, 1, 20}
        };

        for (int i = 0; i < invalidDates.length; ++i) {
            final int idxI = i;

            assertThrows(InvalidMenuDate.class, () -> {
                    new MenuDate(invalidDates[idxI][0], invalidDates[idxI][1], invalidDates[idxI][2]);
            });
        }
    }

    @Test
    void date_is_created_with_valid_data() throws InvalidMenuDate {
        assertAll(() -> {
                new MenuDate(2024, 1, 1);
                new MenuDate(2024, 0, 1);
                new MenuDate(2024, 11, 3);
                new MenuDate(2024, 1, 4);
                new MenuDate(2024, 3, 5);
        });
    }
}
