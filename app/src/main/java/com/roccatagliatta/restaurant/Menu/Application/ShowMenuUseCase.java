package com.roccatagliatta.restaurant.Menu.Application;

import java.util.Map;
import java.util.Optional;

import com.roccatagliatta.restaurant.Menu.Application.Exception.ShowMenuUseCaseException;
import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Domain.Persistence.MenuRepository;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuMonth;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuWeek;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuYear;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuWeekException;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMonthException;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidYearException;
import com.roccatagliatta.restaurant.Menu.Infrastructure.ShowMenuRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ShowMenuUseCase {

    @Autowired
    private MenuRepository repository;

    public void run(final ShowMenuRequest req, Map<String, Object> res) throws ShowMenuUseCaseException {
        try {
            final MenuYear year = new MenuYear(req.year());
            final MenuMonth month = new MenuMonth(req.month());
            final MenuWeek week = new MenuWeek(req.week());

            Optional<Menu> menu = repository.find(year, month, week);

            res.put("menu", menu.isPresent() ? menu.get() : null);
        } catch (final InvalidYearException ex) {
            throw ShowMenuUseCaseException.invalidYear();
        } catch (final InvalidMonthException ex) {
            throw ShowMenuUseCaseException.invalidMonth();
        } catch (final InvalidMenuWeekException ex) {
            throw ShowMenuUseCaseException.invalidWeek();
        }
    }
}
