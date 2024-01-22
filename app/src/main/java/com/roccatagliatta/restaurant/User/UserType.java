package com.roccatagliatta.restaurant.User;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserTypeException;

public enum UserType {
    CUSTOMER(0),
    WAITER(1),
    MANAGER(2);

    private final int value;

    private UserType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static UserType valueOf(int value) throws InvalidUserTypeException {
        for (UserType type : UserType.values()) {
            if (type.value == value) {
                return type;
            }
        }

        throw new InvalidUserTypeException();
    }
}
