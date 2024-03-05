package com.roccatagliatta.restaurant.Reservation.Domain.Persistence;

import java.util.Optional;
import java.util.List;

import com.roccatagliatta.restaurant.Reservation.Domain.Table;

public interface TableRepository {

    public Optional<List<Table>> findAvailableTables(final String startDate, final String endDate);

}
