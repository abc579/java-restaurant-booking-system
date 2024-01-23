package com.roccatagliatta.restaurant.User.Value;

import java.util.UUID;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserIdException;

public final class UserId {
    private UUID value;
    private static final String REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    public UserId(String id) throws InvalidUserIdException {
        if (id == null) {
            throw new InvalidUserIdException();
        }

        // We'll validate this ourselves because Java's fromString method from the UUID
        // class sucks.
        if (!id.matches(REGEX)) {
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
}
