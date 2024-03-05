package com.roccatagliatta.restaurant.Reservation.Application;

import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
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

    // TODO: this probably needs cleanup.
    public void run(final ShowAvailableTablesRequest req, Map<String, List<Table>> res)
        throws ShowAvailableTablesUseCaseException {
        try {
            final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            final LocalDateTime givenDateTime = LocalDateTime.parse(req.dateTime(), formatter);
            final LocalDateTime givenDateTimePlusTwoHours = LocalDateTime.parse(req.dateTime(), formatter);
            givenDateTimePlusTwoHours.plusHours(2);
            final Instant givenInstant = givenDateTime.toInstant(ZoneOffset.UTC);
            final Instant givenInstantPlusTwoHours = givenDateTimePlusTwoHours.toInstant(ZoneOffset.UTC);
            final Instant now = Instant.now();

            if (givenInstant.isBefore(now)) {
                throw ShowAvailableTablesUseCaseException.invalidDate();
            }

            final Optional<List<Table>> availableTables = repository.findAvailableTables(givenInstant.toString(), givenInstantPlusTwoHours.toString());

            res.put("tables", availableTables.get());
        } catch (final ShowAvailableTablesUseCaseException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw ShowAvailableTablesUseCaseException.internalError();
        }
    }
}
