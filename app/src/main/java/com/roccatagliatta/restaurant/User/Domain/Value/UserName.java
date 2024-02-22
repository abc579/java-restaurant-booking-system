package com.roccatagliatta.restaurant.User.Domain.Value;

import com.roccatagliatta.restaurant.User.Domain.Exception.InvalidUserNameException;

public final class UserName {

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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserName userName = (UserName) object;
        return java.util.Objects.equals(value, userName.value);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), value);
    }
}
