package com.roccatagliatta.restaurant.Menu.Domain.Value;

import java.math.BigDecimal;
import java.util.UUID;

public final class MenuItem {

    private UUID id;
    private String name;
    private String description;
    private MenuItemCategory category;
    private BigDecimal price;

}
