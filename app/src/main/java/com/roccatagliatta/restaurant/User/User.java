package com.roccatagliatta.restaurant.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import com.roccatagliatta.restaurant.User.Role.Role;

// @TO DO: we're returning references here, that could be dangerous?
// Perhaps we should return copies of our members so they cannot modify
// internal data thru' pointers.

@Entity
@Table(name = "users")
public final class User {

    private UserId id;

    private UserName username;

    private UserPassword password;

    private UserEmail email;

    private Role role;

    public User(UserId id,
                UserName username,
                UserPassword password,
                UserEmail email,
                Role role)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
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

    public Role role() {
        return role;
    }
}
