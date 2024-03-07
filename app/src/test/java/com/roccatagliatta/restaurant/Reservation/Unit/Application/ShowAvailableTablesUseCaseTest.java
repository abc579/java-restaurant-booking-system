package com.roccatagliatta.restaurant.Reservation.Unit.Application;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.roccatagliatta.restaurant.Reservation.Infrastructure.ShowAvailableTablesRequest;
import com.roccatagliatta.restaurant.Reservation.Application.ShowAvailableTablesUseCase;
import com.roccatagliatta.restaurant.Reservation.Application.Exception.ShowAvailableTablesUseCaseException;
import com.roccatagliatta.restaurant.Reservation.Domain.Persistence.TableRepository;
import com.roccatagliatta.restaurant.Reservation.Domain.Table;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public final class ShowAvailableTablesUseCaseTest {

    @Mock
    private TableRepository repository;

    @InjectMocks
    private ShowAvailableTablesUseCase useCase;

    public void setup() {
        repository = Mockito.mock(TableRepository.class);
    }

    @Test
    void ensure_repository_find_available_tables_is_called_once() throws ShowAvailableTablesUseCaseException {
        Mockito.when(repository.findAvailableTables(any(String.class), any(String.class), any(Integer.class))).thenReturn(null);

        final ShowAvailableTablesRequest req = new ShowAvailableTablesRequest("2999-01-01T00:00:00+00:00", 1);
        Map<String, List<Table>> res = new HashMap<>();

        useCase.run(req, res);

        verify(repository, times(1)).findAvailableTables(any(String.class), any(String.class), any(Integer.class));
    }

    @Test
    void exception_is_thrown_with_invalid_date() {
        final ShowAvailableTablesRequest[] req = {
            new ShowAvailableTablesRequest("2999-01-00T00:30:00+00:00", 1),
            new ShowAvailableTablesRequest("2999-01-01T00:60:00+00:00", 1),
            new ShowAvailableTablesRequest("2999-00-01T00:30:00+00:00", 1),
            new ShowAvailableTablesRequest("2999-00-01T-00:00:00+00:00", 1),
        };

        Map<String, List<Table>> res = new HashMap<>();

        var exception0 = assertThrows(ShowAvailableTablesUseCaseException.class, () -> { useCase.run(req[0], res); });
        var exception1 = assertThrows(ShowAvailableTablesUseCaseException.class, () -> { useCase.run(req[1], res); });
        var exception2 = assertThrows(ShowAvailableTablesUseCaseException.class, () -> { useCase.run(req[2], res); });
        var exception3 = assertThrows(ShowAvailableTablesUseCaseException.class, () -> { useCase.run(req[3], res); });

        assertEquals(ShowAvailableTablesUseCaseException.INVALID_DATE, exception0.errorCode);
        assertEquals(ShowAvailableTablesUseCaseException.INVALID_DATE, exception1.errorCode);
        assertEquals(ShowAvailableTablesUseCaseException.INVALID_DATE, exception2.errorCode);
        assertEquals(ShowAvailableTablesUseCaseException.INVALID_DATE, exception3.errorCode);
    }

    /* i can't fucking test this because mockito wont allow me to use a checked exception, dumb shit
    @Test
    void exception_is_thrown_when_something_goes_wrong_in_repository() {
        Mockito.when(repository.findAvailableTables(any(String.class), any(String.class), any(Integer.class)))
            .thenThrow(ShowAvailableTablesUseCaseException.internalError());

        final ShowAvailableTablesRequest req = new ShowAvailableTablesRequest("2999-01-01T00:00:00", 1);
        Map<String, List<Table>> res = new HashMap<>();

        var exception = assertThrows(ShowAvailableTablesUseCaseException.class, () -> { useCase.run(req, res); });

        assertEquals(ShowAvailableTablesUseCaseException.INTERNAL_ERROR, exception.errorCode);
    }
    */
}
