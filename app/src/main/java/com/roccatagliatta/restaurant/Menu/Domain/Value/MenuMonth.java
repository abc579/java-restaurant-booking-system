package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMonthException;

public final class MenuMonth {

    private int value;

    public MenuMonth(final String monthStr) throws InvalidMonthException {
        if (monthStr == null || monthStr.isEmpty()) {
            throw new InvalidMonthException();
        }

        int month = 0;

        try {
            month = Integer.parseInt(monthStr);
        } catch (final NumberFormatException ex) {
            throw new InvalidMonthException();
        }

        if (month < 0 || month > 11) {
            throw new InvalidMonthException();
        }

        this.value = month;
    }

    public int value() {
        return value;
    }
}
