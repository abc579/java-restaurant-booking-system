package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.MenuItemDescriptionException;

public final class MenuItemDescription {

    private String value;

    public MenuItemDescription(String description) throws MenuItemDescriptionException {
        if (description == null || description.isEmpty() || description.length() > 255) {
            throw new MenuItemDescriptionException();
        }

        this.value = description;
    }

    public String value() {
        return value;
    }
}
