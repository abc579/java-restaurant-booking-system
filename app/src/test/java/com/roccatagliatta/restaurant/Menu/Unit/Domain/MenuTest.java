package com.roccatagliatta.restaurant.Menu.Unit.Domain;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

import com.roccatagliatta.restaurant.Menu.Domain.Menu;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuDate;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItem;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemName;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemDescription;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemCategory;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemPrice;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class MenuTest {

    @Test
    void menu_is_created_with_valid_data_and_returns_correct_values() throws Exception {
        final MenuId id = new MenuId("e3e3884e-4885-4cc1-91a9-801a655c6e5d");
        final MenuDate date = new MenuDate(2024, 2, 1);
        final List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(new MenuItemId("f04645b8-6ad2-411f-b68f-75722700a8e6"),
                               new MenuItemName("Food name test"),
                               new MenuItemDescription("Food name description"),
                               MenuItemCategory.DESSERTS,
                               new MenuItemPrice("20.00")));

        assertAll(() -> {
                final Menu menu = new Menu(id, date, items);

                assertEquals("e3e3884e-4885-4cc1-91a9-801a655c6e5d", menu.getId().getValue().toString());

                assertEquals(2024, menu.getDate().year());
                assertEquals(2, menu.getDate().month());
                assertEquals(1, menu.getDate().day());

                assertEquals("f04645b8-6ad2-411f-b68f-75722700a8e6", menu.getItems().get(0).getId().getValue().toString());
                assertEquals("Food name test", menu.getItems().get(0).getName().getValue());
                assertEquals("Food name description", menu.getItems().get(0).getDescription().getValue());
                assertEquals(MenuItemCategory.DESSERTS, menu.getItems().get(0).getCategory());
                assertEquals(2, menu.getItems().get(0).getCategory().getValue());
                assertEquals(new BigDecimal("20.00"), menu.getItems().get(0).getPrice().getValue());
        });
    }
}
