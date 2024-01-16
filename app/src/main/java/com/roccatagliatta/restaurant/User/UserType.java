package com.roccatagliatta.restaurant.User;

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
}
