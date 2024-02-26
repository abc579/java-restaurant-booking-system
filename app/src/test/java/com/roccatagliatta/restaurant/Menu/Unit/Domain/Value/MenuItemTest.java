package com.roccatagliatta.restaurant.Menu.Unit.Domain.Value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItem;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemName;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemDescription;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemCategory;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemPrice;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemDescription;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemName;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemDescription;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemPrice;

public final class MenuItemTest {

    @Test
    void menu_item_is_created_with_valid_data_and_returns_correct_values()
        throws InvalidMenuItemId, InvalidMenuItemName, InvalidMenuItemDescription, InvalidMenuItemPrice {
        final MenuItemId id = new MenuItemId("c1350cc9-3598-48cf-8591-247d2bc8b194");
        final MenuItemName name = new MenuItemName("Food Name");
        final MenuItemDescription description = new MenuItemDescription("Food Description");
        final MenuItemCategory category = MenuItemCategory.APPETIZERS;
        final MenuItemPrice price = new MenuItemPrice("71.61");

        final MenuItem menuItem = new MenuItem(id, name, description, category, price);

        assertEquals(id.value().toString(), menuItem.id().value().toString());
        assertEquals(name.value(), menuItem.name().value());
        assertEquals(description.value(), menuItem.description().value());
        assertEquals(category.value(), menuItem.category().value());
        assertEquals(price.value(), menuItem.price().value());
    }
}
