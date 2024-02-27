package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.util.UUID;

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

    public RestaurantId value() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
