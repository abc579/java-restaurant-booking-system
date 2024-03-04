package com.roccatagliatta.restaurant.Reservation.Infrastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ShowAvailableTablesController {

    @Autowired
    private ShowAvailableTablesUseCase useCase;

    @GetMapping("/table/show")
    public ResponseEntity<?> show(@RequestParam(value = "dateTime") String dateTime,
                                  @RequestParam(value = "guests") int guests) {
        try {
            final ShowAvailableTablesRequest req = new ShowAvailableTablesRequest(dateTime, guests);

            Map<String, List<Table>> res = new HashMap<>();

            useCase.run(res, req);

            return ResponseEntity.ok().body(res);
        } catch (final ShowAvailableTablesUseCaseException ex) {
            Map<String, String> res = new HashMap<>();

            switch (ex.errorCode) {
            case ShowAvailableTablesUseCaseException.INVALID_DATE:
                res.put("error", "Invalid date.");
                break;
            }

            return ResponseEntity.badRequest().body(res);
        }
    }
}
