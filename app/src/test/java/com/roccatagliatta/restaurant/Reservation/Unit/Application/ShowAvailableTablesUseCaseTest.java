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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        Mockito.when(repository.findAvailableTables(any(String.class), any(String.class))).thenReturn(Optional.empty());

        final ShowAvailableTablesRequest req = new ShowAvailableTablesRequest("2999-01-01T00:00:00", 1);
        Map<String, List<Table>> res = new HashMap<>();

        useCase.run(req, res);

        verify(repository, times(1)).findAvailableTables(any(String.class), any(String.class));
    }

    @Test
    void exception_is_thrown_with_invalid_date() {
        
    }

    @Test
    void exception_is_thrown_when_something_goes_wrong_in_repository() {
        
    }

    @Test
    void table_is_returned_when_there_are_available_tables() {
        
    }

    @Test
    void null_is_returned_when_there_are_not_available_tables() {
        
    }
}
