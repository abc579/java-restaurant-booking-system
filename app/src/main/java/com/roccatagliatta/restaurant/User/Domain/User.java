package com.roccatagliatta.restaurant.User.Domain;

import java.util.Objects;

import com.roccatagliatta.restaurant.User.Domain.Value.*;

public final class User {

    private UserId id;

    private UserName username;

    private UserPassword password;

    private UserEmail email;

    private UserType type;

    public User(UserId id,
            UserName username,
            UserEmail email,
            UserPassword password,
            UserType type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    public UserId id() {
        return id;
    }

    public UserName username() {
        return username;
    }

    public UserPassword password() {
        return password;
    }

    public UserEmail email() {
        return email;
    }

    public UserType type() {
        return type;
    }

    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || getClass() != object.getClass())
            return false;

        User user = (User) object;

        return Objects.equals(id, user.id) && Objects.equals(username, user.username)
                && Objects.equals(password, user.password) && Objects.equals(email, user.email)
                && Objects.equals(type, user.type);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, username, password, email, type);
    }
}
