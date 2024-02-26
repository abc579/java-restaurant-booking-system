package com.roccatagliatta.restaurant.Menu.Infrastructure.Persistence;

import java.util.Optional;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItem;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemId;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemName;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemDescription;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemCategory;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuItemPrice;
import com.roccatagliatta.restaurant.Menu.Domain.Persistence.MenuRepository;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuMonth;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuWeek;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuYear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public final class MySQLMenuRepository implements MenuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Menu> find(final MenuYear year, final MenuMonth month, final MenuWeek week) {
        // @NOTE: This will return a single value!
        List<Menu> menu = jdbcTemplate.query("select id, year, month, week from menus where year = ? and month = ? and week = ?",
                (rs, rowNum) -> {
                    try {
                        final MenuId id = new MenuId(UUID.fromString(rs.getString("id")));
                        return new Menu(id, year, month, week);
                    } catch (final Exception ex) {
                        return null;
                    }
                }, year.value(), month.value(), week.value());

        if (menu.isEmpty()) {
            return Optional.empty();
        }

        List<MenuItem> menuItems = jdbcTemplate.query("select id, name, description, category, price from menu_items where menu_id = ?",
                (rs, rowNum) -> {
                    try {
                        final MenuItemId id = new MenuItemId(UUID.fromString(rs.getString("id")));
                        final MenuItemName name = new MenuItemName(rs.getString("name"));
                        final MenuItemDescription description = new MenuItemDescription(rs.getString("description"));
                        final MenuItemCategory category = MenuItemCategory.valueOf(Integer.parseInt(rs.getString("category")));
                        final MenuItemPrice price = new MenuItemPrice(new BigDecimal(rs.getString("price")));

                        return new MenuItem(id, name, description, category, price);
                    } catch (final Exception ex) {
                        return null;
                    }
                }, menu.get(0).id().value());

        menu.get(0).setMenuItems(menuItems);

        return Optional.ofNullable(menu.get(0));
    }
}
