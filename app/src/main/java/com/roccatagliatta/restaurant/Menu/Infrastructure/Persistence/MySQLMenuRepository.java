package com.roccatagliatta.restaurant.Menu.Infrastructure.Persistence;

import java.util.Optional;
import java.util.List;

import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Domain.Persistence.MenuRepository;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuMonth;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuWeek;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuYear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public final class MySQLMenuRepository implements MenuRepository {

    private static final String List = null;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Menu> find(MenuYear year, MenuMonth month, MenuWeek week) {
        List<Menu> menu = jdbcTemplate.query("select * from menus where year = ? and month = ? and week = ?",
                (rs, rowNum) -> {
                    try {
                        // ...
                        return new Menu(year, month, week);
                    } catch (final Exception ex) {
                        return null;
                    }
                }, year.value(), month.value(), week.value());

        return menu.isEmpty() ? Optional.empty() : Optional.ofNullable(menu.get(0));
    }
}
