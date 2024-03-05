package com.roccatagliatta.restaurant.Reservation.Domain.Value;

import com.roccatagliatta.restaurant.Reservation.Domain.Value.Exception.InvalidTableId;

public final class TableId {

    private int id;

    public TableId(String idStr) throws InvalidTableId {
        try {
            final int id = Integer.valueOf(idStr);

            if (id <= 0) {
                throw new InvalidTableId();
            }

            this.id = id;
        } catch (final NumberFormatException ex) {
            throw new InvalidTableId();
        }
    }

    public int getId() {
        return id;
    }
}
