package com.roccatagliatta.restaurant;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class AppController {

    @GetMapping("/")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String home() {
        return "Welcome customer!";
    }

}
