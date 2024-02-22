package com.roccatagliatta.restaurant.User.Infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.google.common.net.HttpHeaders;

import com.roccatagliatta.restaurant.Security.JwtUtils;
import com.roccatagliatta.restaurant.User.Application.UseCase.SignInUseCase;
import com.roccatagliatta.restaurant.User.Application.UseCase.Exception.SignInUseCaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class SignInController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/user/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest request) throws SignInUseCaseException {
        Map<String, Object> response = new HashMap<>();

        try {
            SignInUseCase useCase = new SignInUseCase(authenticationManager, jwtUtils);

            useCase.run(request, response);

            // XXX: nasty hack, not good.
            String jwtCookie = (String) response.get("jwtCookie");
            response.remove("jwtCookie");

            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie).body(response);
        } catch (final SignInUseCaseException ex) {
            switch (ex.errorCode) {
                case SignInUseCaseException.BAD_CREDENTIALS:
                    response.put("message", "Bad Credentials");
                    break;
            }

            return ResponseEntity.ok().body(response);
        }

    }
}
