package com.roccatagliatta.restaurant.Menu.Domain;

import java.util.List;
import java.util.UUID;

import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuMonth;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuWeek;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuYear;

public final class Menu {

    private UUID id;
    private MenuYear year;
    private MenuMonth month;
    private MenuWeek week;
    private List<MenuItem> items;

    public MenuYear year() {
        return year;
    }

    public MenuMonth month() {
        return month;
    }

    public MenuWeek week() {
        return week;
    }

    public UUID id() {
        return id;
    }

    public List<MenuItem> items() {
        return items;
    }
}
