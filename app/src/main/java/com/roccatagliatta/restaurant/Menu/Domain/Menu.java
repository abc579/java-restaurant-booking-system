package com.roccatagliatta.restaurant.Menu.Domain;

import java.util.List;
import java.util.UUID;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuDate;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItem;

public final class Menu {

    private MenuId id;
    private MenuDate date;
    private List<MenuItem> items;

    public Menu(final MenuId id, final MenuDate date) {
        this.id = id;
        this.date = date;
    }

    public Menu(final MenuId id, final MenuDate date, final List<MenuItem> items) {
        this(id, date);
        this.items = items;
    }

    public MenuId id() {
        return id;
    }

    public List<MenuItem> items() {
        return List.copyOf(items);
    }

    public void setMenuItems(final List<MenuItem> items) {
        this.items = items;
    }
}
