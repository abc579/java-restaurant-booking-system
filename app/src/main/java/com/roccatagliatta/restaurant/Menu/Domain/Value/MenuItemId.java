package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.util.UUID;

public final class MenuItemId {

    private UUID value;

    public MenuItemId(UUID value) {
        this.value = value;
    }

    public UUID value() {
        return value;
    }
}
