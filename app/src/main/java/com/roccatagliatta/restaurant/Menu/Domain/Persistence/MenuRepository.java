package com.roccatagliatta.restaurant.Menu.Domain.Persistence;

import java.util.Optional;

import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuMonth;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuWeek;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuYear;

public interface MenuRepository {

    public Optional<Menu> find(MenuYear year, MenuMonth month, MenuWeek week);

}
