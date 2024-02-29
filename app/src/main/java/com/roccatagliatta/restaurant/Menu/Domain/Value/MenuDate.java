package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuDate;

public final class MenuDate {

    private static final int RESTAURANT_OPEN_YEAR = 2023;
    private Calendar value;

    public MenuDate(final String year, final String month, final String day) throws InvalidMenuDate {
        try {
            final Integer yearInt = Integer.valueOf(year);
            final Integer monthInt = Integer.valueOf(month);
            final Integer dayInt = Integer.valueOf(day);

            // Trivial stuff that GregorianCalendar handles differently and it's confusing, plus one
            // quick validation for the year.
            if (monthInt < 0 || monthInt > 11 || dayInt < 0 || yearInt < RESTAURANT_OPEN_YEAR) {
                throw new InvalidMenuDate();
            }

            value = new GregorianCalendar(yearInt, monthInt, dayInt);
        } catch (final IllegalArgumentException ex) {
            throw new InvalidMenuDate();
        }
    }

    public int year() {
        return value.get(Calendar.YEAR);
    }

    public int month() {
        return value.get(Calendar.MONTH);
    }

    public int day() {
        return value.get(Calendar.DAY_OF_MONTH);
    }

    public String toString() {
        return value.toString();
    }

    // NOTE: this is needed for the bloody jackson lib
    public Calendar value() {
        return value;
    }
}
