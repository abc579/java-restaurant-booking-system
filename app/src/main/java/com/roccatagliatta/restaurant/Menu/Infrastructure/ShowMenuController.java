package com.roccatagliatta.restaurant.Menu.Infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.roccatagliatta.restaurant.Menu.Domain.Menu;
import com.roccatagliatta.restaurant.Menu.Application.ShowMenuUseCase;
import com.roccatagliatta.restaurant.Menu.Application.Exception.ShowMenuUseCaseException;

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
    public ResponseEntity<?> show(@RequestBody final ShowMenuRequest req) {
        try {
            Map<String, Menu> res = new HashMap<>();

            useCase.run(req, res);

            return ResponseEntity.ok().body("You're bad");
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
