package com.roccatagliatta.restaurant.User.Value;

import com.roccatagliatta.restaurant.PasswordEncryptor.PasswordEncryptor;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserPasswordException;

public final class UserPassword {
    private String value;
    private static final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    private UserPassword(String password) {
        value = password;
    }

    public static UserPassword fromPlain (String password, PasswordEncryptor encryptor) throws InvalidUserPasswordException {
        if (password == null || !password.matches(REGEX)) {
            throw new InvalidUserPasswordException();
        }

        return new UserPassword(encryptor.encrypt(password));
    }

    public static UserPassword fromEncrypted(String encrypted) throws InvalidUserPasswordException {
        if (encrypted == null) {
            throw new InvalidUserPasswordException();
        }

        return new UserPassword(encrypted);
    }

    public String value() {
        return value;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserPassword that = (UserPassword) object;
        return java.util.Objects.equals(value, that.value);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), value);
    }
}
