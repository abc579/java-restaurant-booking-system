package com.roccatagliatta.restaurant.User.Domain.Value;

import com.roccatagliatta.restaurant.User.Domain.Exception.InvalidUserTypeException;

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
}
