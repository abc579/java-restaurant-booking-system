package com.roccatagliatta.restaurant.User.Role;

public final class Role {

    private RoleId id;

    private RoleName name;

    public Role(RoleId id,
                RoleName name)
    {
        this.id = id;
        this.name = name;
    }

    public RoleId id() {
        return id;
    }

    public RoleName name() {
        return name;
    }
}
