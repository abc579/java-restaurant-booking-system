package com.roccatagliatta.restaurant.Reservation.Unit.Domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;

import com.roccatagliatta.restaurant.Reservation.Domain.Table;
import com.roccatagliatta.restaurant.Reservation.Domain.Value.TableId;
import com.roccatagliatta.restaurant.Reservation.Domain.Value.TableSeats;

public final class TableTest {

    @Test
    void table_is_created_with_valid_data() throws Exception {
        assertAll(() -> {
                new Table(new TableId("1"),
                          new TableSeats("2"));
        });
    }
}
