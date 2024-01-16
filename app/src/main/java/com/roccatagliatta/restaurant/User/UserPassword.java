package com.roccatagliatta.restaurant.User;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserPasswordException;

final class UserPassword {
    private String value;
    private static final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public UserPassword(String password) {
        if (password == null || !password.matches(REGEX)) {
            throw new InvalidUserPasswordException();
        }

        this.value = password;
    }

    public String value() {
        return value;
    }
}
