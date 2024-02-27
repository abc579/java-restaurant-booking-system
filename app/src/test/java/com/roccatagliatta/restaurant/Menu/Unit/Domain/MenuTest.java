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
        final MenuDate date = new MenuDate("2024", "2", "0");
        final List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(new MenuItemId("f04645b8-6ad2-411f-b68f-75722700a8e6"),
                               new MenuItemName("Food name test"),
                               new MenuItemDescription("Food name description"),
                               MenuItemCategory.DESSERTS,
                               new MenuItemPrice("20.00")));

        assertAll(() -> {
                final Menu menu = new Menu(id, date, items);

                assertEquals("e3e3884e-4885-4cc1-91a9-801a655c6e5d", menu.id().value().toString());

                assertEquals(2024, menu.date().year());
                assertEquals(2, menu.date().month());
                assertEquals(1, menu.date().week());

                assertEquals("f04645b8-6ad2-411f-b68f-75722700a8e6", menu.items().get(0).id().value().toString());
                assertEquals("Food name test", menu.items().get(0).name().value());
                assertEquals("Food name description", menu.items().get(0).description().value());
                assertEquals(MenuItemCategory.DESSERTS, menu.items().get(0).category());
                assertEquals(2, menu.items().get(0).category().value());
                assertEquals(new BigDecimal("20.00"), menu.items().get(0).price().value());
        });
    }
}
