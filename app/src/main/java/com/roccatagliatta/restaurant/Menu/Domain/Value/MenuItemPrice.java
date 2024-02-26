package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.math.BigDecimal;

public final class MenuItemPrice {

    private BigDecimal value;

    public MenuItemPrice(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal value() {
        return value;
    }
}
