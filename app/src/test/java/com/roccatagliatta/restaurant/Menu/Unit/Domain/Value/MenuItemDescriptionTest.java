package com.roccatagliatta.restaurant.Menu.Unit.Domain.Value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemDescription;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemDescription;

public final class MenuItemDescriptionTest {

    @Test
    void exception_is_thrown_when_description_exceeds_max_length() {
        final String veryLongName = "a".repeat(500);

        assertThrows(InvalidMenuItemDescription.class, () -> {
                final MenuItemDescription description = new MenuItemDescription(veryLongName);
        });
    }

    @Test
    void creates_menu_item_description_with_valid_description() {
        final String valid = "Random Food Description";

        try {
            final MenuItemDescription description = new MenuItemDescription(valid);

            assertEquals(valid, description.getValue());
        } catch (final Exception ex) {
            assertTrue(false);
        }
    }
}
