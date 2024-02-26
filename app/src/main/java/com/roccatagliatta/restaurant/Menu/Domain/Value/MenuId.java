package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.util.UUID;

public final class MenuId {

    private UUID value;

    public MenuId(UUID value) {
        this.value = value;
    }

    public UUID value() {
        return value;
    }
}
