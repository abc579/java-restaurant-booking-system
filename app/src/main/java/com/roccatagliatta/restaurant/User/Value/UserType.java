package com.roccatagliatta.restaurant.User.Value;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserTypeException;

public enum UserType {
    CUSTOMER(0),
    WAITER(1),
    MANAGER(2);

    private final int value;

    private UserType(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static UserType valueOf(final int value) throws InvalidUserTypeException {
        for (UserType type : UserType.values()) {
            if (type.value == value) {
                return type;
            }
        }

        throw new InvalidUserTypeException();
    }

    public static boolean exists(final String type) {
        try {
            UserType exists = UserType.valueOf(type);
            return exists != null;
        } catch (final IllegalArgumentException ex) {
            return false;
        }
    }
}
