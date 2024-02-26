package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.math.BigDecimal;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemPrice;

public final class MenuItemPrice {

    private BigDecimal value;

    public MenuItemPrice(String price) throws InvalidMenuItemPrice {
        try {
            value = new BigDecimal(price);
        } catch (final NumberFormatException ex) {
            throw new InvalidMenuItemPrice();
        }
    }

    public BigDecimal value() {
        return value;
    }
}
