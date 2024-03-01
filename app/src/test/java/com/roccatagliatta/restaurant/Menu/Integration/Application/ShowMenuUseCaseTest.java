package com.roccatagliatta.restaurant.Menu.Integration.Application;

import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.roccatagliatta.restaurant.Menu.Infrastructure.ShowMenuRequest;
import com.roccatagliatta.restaurant.Menu.Application.ShowMenuUseCase;
import com.roccatagliatta.restaurant.Menu.Application.Exception.ShowMenuUseCaseException;
import com.roccatagliatta.restaurant.Menu.Domain.Persistence.MenuRepository;
import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItem;

@SpringBootTest
@Transactional
public class ShowMenuUseCaseTest {

    @Autowired
    private MenuRepository repository;

    @Autowired
    private ShowMenuUseCase useCase;

    @Test
    void empty_menu_is_returned_when_no_data_is_found() throws ShowMenuUseCaseException {
        final ShowMenuRequest req = new ShowMenuRequest(2023, 0, 0);
        Map<String, Menu> res = new HashMap<>();

        useCase.run(req, res);

        assertNull(res.get("menu"));
    }

    @Test
    void menu_is_returned_when_data_is_found() throws ShowMenuUseCaseException {
        final ShowMenuRequest req = new ShowMenuRequest(2024, 1, 1);
        Map<String, Menu> res = new HashMap<>();

        useCase.run(req, res);

        assertNotNull(res.get("menu"));

        final Menu menu = (Menu) res.get("menu");
        final MenuItem menuItem = menu.getItems().get(0);

        assertEquals("e03d8309-41fd-4dfd-979d-fd5663e911bb", menu.getId().getValue().toString());
        assertEquals(2024, menu.getDate().year());
        assertEquals(1, menu.getDate().month());
        assertEquals(1, menu.getDate().day());

        assertEquals("bcccbdd2-777b-4e44-8198-0b59f9793a82", menuItem.getId().getValue().toString());
        assertEquals("Dummy Food Name", menuItem.getName().getValue());
        assertEquals("Dummy Food Description", menuItem.getDescription().getValue());
        assertEquals(0, menuItem.getCategory().getValue());
        assertEquals(new BigDecimal("20.55"), menuItem.getPrice().getValue());
    }
}
