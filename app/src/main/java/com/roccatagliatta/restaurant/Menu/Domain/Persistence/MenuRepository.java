package com.roccatagliatta.restaurant.Menu.Domain.Persistence;

import java.util.Optional;

import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuDate;

public interface MenuRepository {

    public Optional<Menu> find(final MenuDate date);

}
