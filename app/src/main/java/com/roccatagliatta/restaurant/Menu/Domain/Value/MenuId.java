package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuId;
import com.roccatagliatta.restaurant.Shared.Domain.RestaurantId;
import com.roccatagliatta.restaurant.Shared.Domain.Exception.InvalidRestaurantIdException;

public final class MenuId {

    private RestaurantId value;

    public MenuId(String value) throws InvalidMenuId {
        try {
            this.value = new RestaurantId(value);
        } catch (final InvalidRestaurantIdException ex) {
            throw new InvalidMenuId();
        }
    }

    public RestaurantId value() {
        return value;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MenuId menuId = (MenuId) object;
        return java.util.Objects.equals(value, menuId.value);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
