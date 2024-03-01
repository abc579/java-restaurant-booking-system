package com.roccatagliatta.restaurant.Menu.Domain;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

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

    public MenuId getId() {
        return id;
    }

    public List<MenuItem> getItems() {
        return List.copyOf(items);
    }

    public MenuDate getDate() {
        return date;
    }

    public void setMenuItems(final List<MenuItem> items) {
        this.items = items;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || getClass() != object.getClass())
            return false;

        final Menu menu = (Menu) object;

        return Objects.equals(id, menu.getId());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
