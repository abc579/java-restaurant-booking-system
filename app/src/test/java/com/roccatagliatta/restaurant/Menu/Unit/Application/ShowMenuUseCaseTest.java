package com.roccatagliatta.restaurant.Menu.Unit.Application;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.math.BigDecimal;

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

import com.roccatagliatta.restaurant.Menu.Infrastructure.ShowMenuRequest;
import com.roccatagliatta.restaurant.Menu.Application.ShowMenuUseCase;
import com.roccatagliatta.restaurant.Menu.Application.Exception.ShowMenuUseCaseException;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuDate;
import com.roccatagliatta.restaurant.Menu.Domain.Persistence.MenuRepository;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuId;
import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItem;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemName;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemDescription;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemCategory;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemPrice;

@ExtendWith(MockitoExtension.class)
public final class ShowMenuUseCaseTest {

    @Mock
    private MenuRepository repository;

    @InjectMocks
    private ShowMenuUseCase useCase;

    public void setup() {
        repository = Mockito.mock(MenuRepository.class);
    }

    @Test
    void ensure_repository_find_method_is_called_once() throws ShowMenuUseCaseException {
        final ShowMenuRequest req = new ShowMenuRequest("2024", "0", "0");
        Map<String, Object> res = new HashMap<>();

        useCase.run(req, res);

        verify(repository, times(1)).find(any(MenuDate.class));
    }

    @Test
    void exception_is_thrown_with_invalid_date() {
        final ShowMenuRequest req = new ShowMenuRequest("2024", "-1", "-1");
        Map<String, Object> res = new HashMap<>();

        var exception = assertThrows(ShowMenuUseCaseException.class, () -> {
                useCase.run(req, res);
        });

        assertEquals(ShowMenuUseCaseException.INVALID_DATE, exception.errorCode);
    }

    @Test
    void empty_menu_is_returned_when_no_data_is_found() throws ShowMenuUseCaseException {
        Mockito.when(repository.find(any())).thenReturn(Optional.empty());

        final ShowMenuRequest req = new ShowMenuRequest("2023", "0", "0");
        Map<String, Object> res = new HashMap<>();

        useCase.run(req, res);

        assertNull(res.get("menu"));
    }

    @Test
    void menu_is_returned_when_data_is_found() throws Exception {
        final ShowMenuRequest req = new ShowMenuRequest("2023", "0", "1");
        Map<String, Object> res = new HashMap<>();

        final MenuId id = new MenuId("e3e3884e-4885-4cc1-91a9-801a655c6e5d");
        final MenuDate date = new MenuDate(req.year(), req.month(), req.day());
        final List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(new MenuItemId("f04645b8-6ad2-411f-b68f-75722700a8e6"),
                               new MenuItemName("Food name test"),
                               new MenuItemDescription("Food name description"),
                               MenuItemCategory.DESSERTS,
                               new MenuItemPrice("20.00")));

        final Menu menu = new Menu(id, date, items);

        Mockito.when(repository.find(any())).thenReturn(Optional.of(menu));

        useCase.run(req, res);

        assertNotNull(res.get("menu"));

        final Menu menuReturned = (Menu) res.get("menu");
        final MenuItem menuItem = menuReturned.items().get(0);

        assertEquals("e3e3884e-4885-4cc1-91a9-801a655c6e5d", menuReturned.id().value().toString());

        assertEquals(2023, menuReturned.date().year());
        assertEquals(0, menuReturned.date().month());
        assertEquals(1, menuReturned.date().day());

        assertEquals("f04645b8-6ad2-411f-b68f-75722700a8e6", menuItem.id().value().toString());
        assertEquals("Food name test", menuItem.name().value());
        assertEquals("Food name description", menuItem.description().value());
        assertEquals(MenuItemCategory.DESSERTS, menuItem.category());
        assertEquals(2, menuItem.category().value());
        assertEquals(new BigDecimal("20.00"), menuItem.price().value());
    }
}
