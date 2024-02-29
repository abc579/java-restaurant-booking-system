package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.math.BigDecimal;
import java.util.UUID;

public final class MenuItem {

    private MenuItemId id;
    private MenuItemName name;
    private MenuItemDescription description;
    private MenuItemCategory category;
    private MenuItemPrice price;

    public MenuItem(final MenuItemId id, final MenuItemName name, final MenuItemDescription description,
                    final MenuItemCategory category, final MenuItemPrice price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public MenuItemId id() {
        return id;
    }

    public MenuItemName name() {
        return name;
    }

    public MenuItemDescription description() {
        return description;
    }

    public MenuItemCategory category() {
        return category;
    }

    public MenuItemPrice price() {
        return price;
    }
}
