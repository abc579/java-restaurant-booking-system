package com.roccatagliatta.restaurant.Menu.Unit.Domain.Value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemPrice;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemPrice;

public final class MenuItemPriceTest {

    @Test
    void exception_is_thrown_when_invalid_price() {
        final String wrongPrice = "12,12b";

        assertThrows(InvalidMenuItemPrice.class, () -> {
                final MenuItemPrice price = new MenuItemPrice(wrongPrice);
        });
    }

    @Test
    void creates_menu_item_price_when_price_is_valid() {
        final String valid = "12.12";

        try {
            final MenuItemPrice price = new MenuItemPrice(valid);

            assertEquals(valid, price.value().toString());
        } catch (final Exception ex) {
            assertTrue(false);
        }
    }
}
