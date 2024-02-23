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
        Map<String, Object> res = new HashMap<>();

        try {
            useCase.run(req, res);

            return ResponseEntity.ok().body(res);
        } catch (final ShowMenuUseCaseException ex) {
            switch (ex.errorCode) {
                case ShowMenuUseCaseException.INVALID_YEAR:
                    res.put("error", "Invalid year.");
                    break;
                case ShowMenuUseCaseException.INVALID_MONTH:
                    res.put("error", "Invalid month.");
                    break;
                case ShowMenuUseCaseException.INVALID_WEEK:
                    res.put("error", "Invalid week.");
                    break;
            }

            return ResponseEntity.badRequest().body(res);
        }
    }
}
