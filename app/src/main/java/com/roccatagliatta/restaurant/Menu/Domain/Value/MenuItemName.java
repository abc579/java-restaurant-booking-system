package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemName;

public final class MenuItemName {

    private String value;

    public MenuItemName(String name) throws InvalidMenuItemName {
        if (name == null || name.isEmpty() || name.length() > 50) {
            throw new InvalidMenuItemName();
        }

        this.value = name;
    }

    public String value() {
        return value;
    }
}
