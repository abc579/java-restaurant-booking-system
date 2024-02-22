package com.roccatagliatta.restaurant.User.Domain.Value;

import java.util.UUID;
import com.roccatagliatta.restaurant.User.Domain.Exception.InvalidUserIdException;

public final class UserId {
    private UUID value;
    private static final String REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    public UserId(String id) throws InvalidUserIdException {
        // We'll validate this ourselves because Java's fromString method from the UUID
        // class sucks.
        if (id == null || !id.matches(REGEX)) {
            throw new InvalidUserIdException();
        }

        try {
            this.value = UUID.fromString(id);
        } catch (final IllegalArgumentException e) {
            throw new InvalidUserIdException();
        }
    }

    public UUID value() {
        return value;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserId userId = (UserId) object;
        return java.util.Objects.equals(value, userId.value);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), value);
    }
}
