package com.roccatagliatta.restaurant.User.Domain.Value;

import com.roccatagliatta.restaurant.User.Domain.Exception.InvalidUserIdException;
import com.roccatagliatta.restaurant.Shared.Domain.RestaurantId;
import com.roccatagliatta.restaurant.Shared.Domain.Exception.InvalidRestaurantIdException;

public final class UserId {
    private RestaurantId value;

    public UserId(String id) throws InvalidUserIdException {
        try {
            this.value = new RestaurantId(id);
        } catch (final InvalidRestaurantIdException ex) {
            throw new InvalidUserIdException();
        }
    }

    public RestaurantId value() {
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

    @Override
    public String toString() {
        return value.toString();
    }
}
