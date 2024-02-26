package com.roccatagliatta.restaurant.Menu.Domain;

import java.util.List;
import java.util.UUID;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuMonth;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuWeek;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuYear;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItem;

public final class Menu {

    private MenuId id;
    private MenuYear year;
    private MenuMonth month;
    private MenuWeek week;
    private List<MenuItem> items;

    public Menu(final MenuId id, final MenuYear year, final MenuMonth month, final MenuWeek week) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.week = week;
    }

    public Menu(final MenuId id, final MenuYear year, final MenuMonth month, final MenuWeek week, final List<MenuItem> items) {
        this(id, year, month, week);
        this.items = items;
    }

    public MenuYear year() {
        return year;
    }

    public MenuMonth month() {
        return month;
    }

    public MenuWeek week() {
        return week;
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
