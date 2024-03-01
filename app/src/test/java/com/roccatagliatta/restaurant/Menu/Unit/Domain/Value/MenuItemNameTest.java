package com.roccatagliatta.restaurant.Menu.Unit.Domain.Value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemName;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemName;

public final class MenuItemNameTest {

    @Test
    void exception_is_thrown_when_name_exceeds_max_length() {
        final String tooLong = "a".repeat(100);

        assertThrows(InvalidMenuItemName.class, () -> {
                final MenuItemName name = new MenuItemName(tooLong);
        });
    }

    @Test
    void creates_menu_item_name_with_valid_name() {
        final String valid = "Random Food Name";

        try {
            final MenuItemName name = new MenuItemName(valid);
            assertEquals(valid, name.getValue());
        } catch (final Exception ex) {
            assertTrue(false);
        }
    }
}
