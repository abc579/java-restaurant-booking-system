package com.roccatagliatta.restaurant.Menu.Infrastructure;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> response = new HashMap<>();

        try {
            useCase.run(req);

            return ResponseEntity.ok().body(response);
        } catch (final ShowMenuUseCaseException ex) {
            switch (ex.errorCode) {
                case ShowMenuUseCaseException.INVALID_YEAR:
                    response.put("error", "Invalid year.");
                    break;
                case ShowMenuUseCaseException.INVALID_MONTH:
                    response.put("error", "Invalid month.");
                    break;
                case ShowMenuUseCaseException.INVALID_WEEK:
                    response.put("error", "Invalid week.");
                    break;
            }

            return ResponseEntity.badRequest().body(response);
        }
    }
}
