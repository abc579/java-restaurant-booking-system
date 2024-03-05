package com.roccatagliatta.restaurant.Reservation.Domain.Value;

import com.roccatagliatta.restaurant.Reservation.Domain.Value.Exception.InvalidTableSeats;

public final class TableSeats {

    private int seats;

    public TableSeats(String seatsStr) throws InvalidTableSeats {
        try {
            final int seats = Integer.valueOf(seatsStr);

            if (seats <= 0 || seats > 10) {
                throw new InvalidTableSeats();
            }

            this.seats = seats;
        } catch (final NumberFormatException ex) {
            throw new InvalidTableSeats();
        }
    }

    public int getSeats() {
        return seats;
    }
}
