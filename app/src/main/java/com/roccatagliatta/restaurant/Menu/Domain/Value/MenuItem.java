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

    public MenuItemId getId() {
        return id;
    }

    public MenuItemName getName() {
        return name;
    }

    public MenuItemDescription getDescription() {
        return description;
    }

    public MenuItemCategory getCategory() {
        return category;
    }

    public MenuItemPrice getPrice() {
        return price;
    }
}
