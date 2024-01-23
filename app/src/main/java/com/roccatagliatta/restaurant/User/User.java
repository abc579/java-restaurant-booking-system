package com.roccatagliatta.restaurant.User;

import com.roccatagliatta.restaurant.User.Value.*;

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
}
