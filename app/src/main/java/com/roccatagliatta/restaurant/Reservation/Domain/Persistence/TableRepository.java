package com.roccatagliatta.restaurant.Reservation.Domain.Persistence;

public interface TableRepository {

    public Optional<List<Table>> findAvailableTables(final String date);

}
