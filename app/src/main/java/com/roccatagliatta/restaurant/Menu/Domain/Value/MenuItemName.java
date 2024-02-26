package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.MenuItemNameException;

public final class MenuItemName {

    private String value;

    public MenuItemName(String name) throws MenuItemNameException {
        if (name == null || name.isEmpty() || name.length() > 50) {
            throw new MenuItemNameException();
        }

        this.value = name;
    }

    public String value() {
        return value;
    }
}
