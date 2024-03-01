package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonValue;

import com.roccatagliatta.restaurant.Shared.Domain.RestaurantId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemId;
import com.roccatagliatta.restaurant.Shared.Domain.Exception.InvalidRestaurantIdException;

public final class MenuItemId {

    private RestaurantId value;

    public MenuItemId(String value) throws InvalidMenuItemId {
        try {
            this.value = new RestaurantId(value);
        } catch (final InvalidRestaurantIdException ex) {
            throw new InvalidMenuItemId();
        }
    }

    @JsonValue
    public RestaurantId getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
