package com.roccatagliatta.restaurant.Menu.Domain.Value;

import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuItemCategoryException;

public enum MenuItemCategory {
    APPETIZERS(0),
    MAIN_COURSES(1),
    DESSERTS(2),
    BEVERAGES(3);

    private final int value;

    private MenuItemCategory(final int value) {
        this.value = value;
    }

    public static MenuItemCategory valueOf(final int value) throws InvalidMenuItemCategoryException {
        for (final MenuItemCategory category : MenuItemCategory.values()) {
            if (category.value == value) {
                return category;
            }
        }

        throw new InvalidMenuItemCategoryException();
    }

    public int value() {
        return value;
    }
}
