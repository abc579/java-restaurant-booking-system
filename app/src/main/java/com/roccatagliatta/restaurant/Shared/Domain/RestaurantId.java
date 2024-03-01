package com.roccatagliatta.restaurant.Shared.Domain;

import java.util.UUID;

import com.roccatagliatta.restaurant.Shared.Domain.Exception.InvalidRestaurantIdException;

public final class RestaurantId {

    private UUID value;
    private static final String REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    public RestaurantId(String value) throws InvalidRestaurantIdException {
        if (value == null || !value.matches(REGEX)) {
            throw new InvalidRestaurantIdException();
        }

        try {
            this.value = UUID.fromString(value);
        } catch (final IllegalArgumentException ex) {
            throw new InvalidRestaurantIdException();
        }
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RestaurantId restaurantId = (RestaurantId) object;
        return java.util.Objects.equals(value, restaurantId.value);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
