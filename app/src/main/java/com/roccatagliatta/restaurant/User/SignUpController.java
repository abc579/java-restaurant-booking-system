package com.roccatagliatta.restaurant.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
public final class SignUpController {

    @PostMapping("/user/signup")
    public String signUp(@RequestBody @Valid SignUpRequest request) {
        return "You're mf valid!";
    }

}
