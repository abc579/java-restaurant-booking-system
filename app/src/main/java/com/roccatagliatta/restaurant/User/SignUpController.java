package com.roccatagliatta.restaurant.User;

import java.util.UUID;

import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserEmailException;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserIdException;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserNameException;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserPasswordException;
import com.roccatagliatta.restaurant.User.Exceptions.SignUpUseCaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public final class SignUpController {

    @Autowired
    private SignUpUseCase useCase;

    @PostMapping("/user/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest request) {
        // @NOTE: with multiple languages this approach is not valid.
        StringBuilder errors = new StringBuilder();
        UserId id = null;
        UserName name = null;
        UserEmail email = null;
        UserPassword password = null;
        UserType type = UserType.CUSTOMER;

        try {
            id = new UserId(UUID.randomUUID().toString());
        } catch (final InvalidUserIdException ex) {
            errors.append("Could not generate id for user.\n");
        }

        try {
            name = new UserName(request.username());
        } catch (final InvalidUserNameException ex) {
            errors.append("Username is not valid.\n");
        }

        try {
            email = new UserEmail(request.email());
        } catch (final InvalidUserEmailException ex) {
            errors.append("Email is not valid.\n");
        }

        try {
            password = new UserPassword(request.password());
        } catch (final InvalidUserPasswordException ex) {
            errors.append("Password is not valid.\n");
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString().trim());
        }

        try {
            useCase.run(id, name, email, password, type);
        } catch (final SignUpUseCaseException ex) {
            // @TODO
            
        }

        return ResponseEntity.ok("Good request!");
    }

}
