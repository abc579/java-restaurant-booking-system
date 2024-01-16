package com.roccatagliatta.restaurant.User;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserNameException;

final class UserName {

    private String value;

    public UserName(String userName) throws InvalidUserNameException {
        if (userName == null || userName.isEmpty() || userName.length() > 32) {
            throw new InvalidUserNameException();
        }

        this.value = userName;
    }

    public String value() {
        return value;
    }
}
