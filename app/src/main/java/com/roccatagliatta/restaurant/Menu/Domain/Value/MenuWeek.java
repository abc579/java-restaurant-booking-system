package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuWeekException;

public final class MenuWeek {

    private int value;

    public MenuWeek(String weekStr) throws InvalidMenuWeekException {
        if (weekStr == null || weekStr.isEmpty()) {
            throw new InvalidMenuWeekException();
        }

        int week = 0;

        try {
            week = Integer.parseInt(weekStr);
        } catch (final NumberFormatException ex) {
            throw new InvalidMenuWeekException();
        }

        if (week < 0 || week > 3) {
            throw new InvalidMenuWeekException();
        }

        this.value = week;
    }

    public int value() {
        return value;
    }
}
