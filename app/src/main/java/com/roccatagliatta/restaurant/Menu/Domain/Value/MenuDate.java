package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuDate;

public final class MenuDate {

    private static final int RESTAURANT_OPEN_YEAR = 2023;
    private Calendar value;

    public MenuDate(String year, String month, String week) throws InvalidMenuDate {
        try {
            final Integer yearInt = Integer.valueOf(year);
            final Integer monthInt = Integer.valueOf(month);
            final Integer weekInt = Integer.valueOf(week);

            // Trivial stuff that GregorianCalendar handles differently and it's confusing, plus one
            // quick validation for the year.
            if (monthInt < 0 || monthInt > 11 || weekInt < 0 || yearInt < RESTAURANT_OPEN_YEAR) {
                throw new InvalidMenuDate();
            }

            value = new GregorianCalendar(yearInt, monthInt, 1);
            value.set(Calendar.WEEK_OF_MONTH, weekInt);
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

    public int week() {
        return value.get(Calendar.WEEK_OF_MONTH);
    }

    public String toString() {
        return value.toString();
    }
}