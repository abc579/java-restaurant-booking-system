package com.roccatagliatta.restaurant.Reservation.Application;

import java.util.Map;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.time.Instant;
import java.time.ZoneOffset;

import com.roccatagliatta.restaurant.Reservation.Domain.Persistence.TableRepository;
import com.roccatagliatta.restaurant.Reservation.Domain.Table;
import com.roccatagliatta.restaurant.Reservation.Infrastructure.ShowAvailableTablesRequest;
import com.roccatagliatta.restaurant.Reservation.Application.Exception.ShowAvailableTablesUseCaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ShowAvailableTablesUseCase {

    @Autowired
    private TableRepository repository;

    public void run(final ShowAvailableTablesRequest req, Map<String, List<Table>> res)
        throws ShowAvailableTablesUseCaseException {
        final ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        ZonedDateTime givenDateTime = null;
        List<Table> availableTables = null;
        ZonedDateTime givenDateTimePlusTwoHours = null;

        try {
            givenDateTime = ZonedDateTime.parse(req.dateTime(), formatter);
            givenDateTimePlusTwoHours = givenDateTime.plusHours(2);

            if (givenDateTime.isBefore(now)) {
                throw ShowAvailableTablesUseCaseException.invalidDate();
            }

        } catch (final Exception ex) {
            throw ShowAvailableTablesUseCaseException.invalidDate();
        }

        try {
            availableTables = repository.
                findAvailableTables(givenDateTime.toString(), givenDateTimePlusTwoHours.toString(), req.seats());
        } catch (final Exception ex) {
            throw ShowAvailableTablesUseCaseException.internalError();
        }

        res.put("tables", availableTables);
    }
}
