package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.annotation.JsonValue;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuDate;

public final class MenuDate {

    private static final int RESTAURANT_OPEN_YEAR = 2023;
    private Calendar value;

    public MenuDate(final int year, final int month, final int day) throws InvalidMenuDate {
        try {
            // Trivial stuff that GregorianCalendar handles differently and it's confusing, plus one
            // quick validation for the year.
            if (month < 0 || month > 11 || day < 0 || year < RESTAURANT_OPEN_YEAR) {
                throw new InvalidMenuDate();
            }

            value = new GregorianCalendar(year, month, day);
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
    @JsonValue
    public Calendar getValue() {
        return value;
    }
}
