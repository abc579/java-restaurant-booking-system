package com.roccatagliatta.restaurant.User;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserEmailException;

final class UserEmail {
    private static final String REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private String value;

    public UserEmail(String email) throws InvalidUserEmailException {
        if (email == null || !email.matches(REGEX)) {
            throw new InvalidUserEmailException();
        }

        this.value = email;
    }

    public String value() {
        return value;
    }
}
