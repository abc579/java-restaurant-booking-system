package com.roccatagliatta.restaurant.Menu.Infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Application.ShowMenuUseCase;
import com.roccatagliatta.restaurant.Menu.Application.Exception.ShowMenuUseCaseException;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ShowMenuController {

    @Autowired
    private ShowMenuUseCase useCase;

    @GetMapping("/menu/show")
    public ResponseEntity<?> show(@RequestParam(value = "year") int year,
                                  @RequestParam(value = "month") int month,
                                  @RequestParam(value = "day") int day) {
        try {
            final ShowMenuRequest req = new ShowMenuRequest(year, month, day);

            Map<String, Menu> res = new HashMap<>();

            useCase.run(req, res);

            return ResponseEntity.ok().body(res);
        } catch (final ShowMenuUseCaseException ex) {
            Map<String, String> res = new HashMap<>();

            switch (ex.errorCode) {
                case ShowMenuUseCaseException.INVALID_DATE:
                    res.put("error", "Invalid date.");
                    break;
            }

            return ResponseEntity.badRequest().body(res);
        }
    }
}
