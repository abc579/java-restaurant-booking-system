package com.roccatagliatta.restaurant.User;

import java.util.UUID;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserIdException;

final class UserId {
    private UUID value;

    public UserId(String id) throws InvalidUserIdException {
        try {
            this.value = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidUserIdException();
        }
    }

    // @TODO: Do we need this?
    public UUID value() {
        return value;
    }
}
