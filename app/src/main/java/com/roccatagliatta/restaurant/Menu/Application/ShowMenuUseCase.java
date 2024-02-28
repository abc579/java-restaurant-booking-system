package com.roccatagliatta.restaurant.Menu.Application;

import java.util.Map;
import java.util.Optional;

import com.roccatagliatta.restaurant.Menu.Application.Exception.ShowMenuUseCaseException;
import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Domain.Persistence.MenuRepository;
import com.roccatagliatta.restaurant.Menu.Domain.Value.MenuDate;
import com.roccatagliatta.restaurant.Menu.Domain.Value.Exception.InvalidMenuDate;
import com.roccatagliatta.restaurant.Menu.Infrastructure.ShowMenuRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ShowMenuUseCase {

    @Autowired
    private MenuRepository repository;

    public void run(final ShowMenuRequest req, Map<String, Object> res) throws ShowMenuUseCaseException {
        try {
            final MenuDate date = new MenuDate(req.year(), req.month(), req.day());

            final Optional<Menu> menu = repository.find(date);

            res.put("menu", menu.isPresent() ? menu.get() : null);
        } catch (final InvalidMenuDate ex) {
            throw ShowMenuUseCaseException.invalidDate();
        }
    }
}
