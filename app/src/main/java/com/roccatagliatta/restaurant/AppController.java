package com.roccatagliatta.restaurant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class AppController {

    @GetMapping("/")
    public String home() {
        return "Welcome!";
    }

}
