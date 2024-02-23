package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidYearException;

public final class MenuYear {

    private int value;
    private static int RESTAURANT_OPEN_YEAR = 2024;

    public MenuYear(final String yearStr) throws InvalidYearException {
        if (yearStr == null || yearStr.isEmpty()) {
            throw new InvalidYearException();
        }

        int year = 0;

        try {
            year = Integer.parseInt(yearStr);
        } catch (final NumberFormatException ex) {
            throw new InvalidYearException();
        }

        if (year < RESTAURANT_OPEN_YEAR) {
            throw new InvalidYearException();
        }

        this.value = year;
    }

    public int value() {
        return value;
    }
}
