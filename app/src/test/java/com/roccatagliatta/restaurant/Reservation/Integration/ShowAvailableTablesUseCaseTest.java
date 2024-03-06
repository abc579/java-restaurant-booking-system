package com.roccatagliatta.restaurant.Reservation.Integration.Application;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.roccatagliatta.restaurant.Reservation.Infrastructure.ShowAvailableTablesRequest;
import com.roccatagliatta.restaurant.Reservation.Application.ShowAvailableTablesUseCase;
import com.roccatagliatta.restaurant.Reservation.Application.Exception.ShowAvailableTablesUseCaseException;
import com.roccatagliatta.restaurant.Reservation.Domain.Table;

@SpringBootTest
public final class ShowAvailableTablesUseCaseTest {

    @Autowired
    private ShowAvailableTablesUseCase useCase;

    @Test
    void null_is_returned_when_no_table_is_available_on_given_datetime() throws ShowAvailableTablesUseCaseException {
        final ShowAvailableTablesRequest req = new ShowAvailableTablesRequest("2099-01-01T10:30:00", 4);
        Map<String, List<Table>> res = new HashMap<>();

        useCase.run(req, res);

        assertTrue(res.get("tables").isEmpty());
    }

    @Test
    void tables_are_returned_when_tables_are_available_on_given_datetime() throws ShowAvailableTablesUseCaseException {
        final ShowAvailableTablesRequest req = new ShowAvailableTablesRequest("2099-01-01T10:00:00", 1);
        Map<String, List<Table>> res = new HashMap<>();

        useCase.run(req, res);

        assertEquals(res.get("tables").size(), 5);
    }
}
