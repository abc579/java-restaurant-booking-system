package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemDescription;

public final class MenuItemDescription {

    private String value;

    public MenuItemDescription(String description) throws InvalidMenuItemDescription {
        if (description == null || description.isEmpty() || description.length() > 255) {
            throw new InvalidMenuItemDescription();
        }

        this.value = description;
    }

    public String getValue() {
        return value;
    }
}
