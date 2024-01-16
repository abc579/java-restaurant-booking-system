package com.roccatagliatta.restaurant.User;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserNameException;

final class UserName {

    private String value;
    private static final String REGEX = "^[a-z]{2,32}$";

    public UserName(String userName) throws InvalidUserNameException {
        if (userName == null || !userName.matches(REGEX)) {
            throw new InvalidUserNameException();
        }

        this.value = userName;
    }

    public String value() {
        return value;
    }
}
