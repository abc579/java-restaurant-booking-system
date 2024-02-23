package com.roccatagliatta.restaurant.Menu.Application;

import com.roccatagliatta.restaurant.Menu.Application.Exception.ShowMenuUseCaseException;
import com.roccatagliatta.restaurant.Menu.Infrastructure.ShowMenuRequest;

import org.springframework.stereotype.Service;

@Service
public final class ShowMenuUseCase {

    public void run(final ShowMenuRequest req) throws ShowMenuUseCaseException {
        if (req.week() == null || req.week().isEmpty()) {
            throw ShowMenuUseCaseException.invalidWeek();
        }

    }
}
