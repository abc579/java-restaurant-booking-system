package com.roccatagliatta.restaurant.User.Domain.Value;

import com.roccatagliatta.restaurant.User.Domain.Exception.InvalidUserEmailException;

public final class UserEmail {
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserEmail userEmail = (UserEmail) object;
        return java.util.Objects.equals(value, userEmail.value);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), value);
    }
}
