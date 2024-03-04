package com.roccatagliatta.restaurant.Reservation.Application;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public final class ShowAvailableTablesUseCase {

    @Autowired
    private TableRepository repository;

    public void run(Map<String, List<Table>> res, final ShowAvailableTablesRequest req)
        throws ShowAvailableTablesUseCaseException {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime givenDateTime = LocalDateTime.parse(req.date, formatter);
        Instant givenInstant = givenDateTime.toInstant(ZoneOffset.UTC);
        Instant now = Instant.now();

        if (givenInstant < now) {
            throw new ShowAvailableTablesUseCaseException.invalidDate();
        }

        List<Table> availableTables = repository.findAvailableTables(givenInstant.toString());

        res.put("tables", availableTables);
    }
}
