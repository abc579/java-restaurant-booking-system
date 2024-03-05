package com.roccatagliatta.restaurant.Reservation.Domain;

import com.roccatagliatta.restaurant.Reservation.Domain.Value.TableId;
import com.roccatagliatta.restaurant.Reservation.Domain.Value.TableSeats;

public final class Table {

    private TableId id;
    private TableSeats seats;

    public Table(final TableId id, final TableSeats seats) {
        this.id = id;
        this.seats = seats;
    }

    public TableId getId() {
        return id;
    }

    public TableSeats getSeats() {
        return seats;
    }
}
