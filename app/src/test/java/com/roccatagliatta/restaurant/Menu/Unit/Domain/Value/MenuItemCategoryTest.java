package com.roccatagliatta.restaurant.Menu.Unit.Domain.Value;

import org.junit.jupiter.api.Test;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemCategory;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemCategoryException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class MenuItemCategoryTest {

    @Test
    void exception_is_thrown_with_invalid_menu_item_category() {
        final String invalid = "69";

        assertThrows(InvalidMenuItemCategoryException.class, () -> {
                MenuItemCategory.valueOf(Integer.valueOf(invalid));
        });
    }

    @Test
    void creates_menu_item_category_with_valid_category() throws InvalidMenuItemCategoryException {
        final String valid = "0";
        final MenuItemCategory category = MenuItemCategory.valueOf(Integer.valueOf(valid));

        assertEquals(category, MenuItemCategory.APPETIZERS);
    }
}
