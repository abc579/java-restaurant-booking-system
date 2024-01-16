package com.roccatagliatta.restaurant.User;

// @TO DO: we're returning references here, that could be dangerous?
// Perhaps we should return copies of our members so they cannot modify
// internal data thru' pointers.

public final class User {

    private UserId id;

    private UserName username;

    private UserPassword password;

    private UserEmail email;

    private UserType type;

    public User(UserId id,
                UserName username,
                UserPassword password,
                UserEmail email,
                UserType type)
    {
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
