package com.roccatagliatta.restaurant.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.roccatagliatta.restaurant.PasswordEncryptor.PasswordEncryptor;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserEmailException;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserIdException;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserNameException;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserPasswordException;
import com.roccatagliatta.restaurant.User.Exceptions.SignUpUseCaseException;
import com.roccatagliatta.restaurant.User.Value.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public final class SignUpController {

    @Autowired
    private SignUpUseCase useCase;

    @Autowired
    private PasswordEncryptor encryptor;

    @PostMapping("/user/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest request) {
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
            password = UserPassword.fromPlain(request.password(), encryptor);
        } catch (final InvalidUserPasswordException ex) {
            errors.append("Password is not valid.\n");
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString().trim());
        }

        User user = new User(id, name, email, password, type);

        try {
            useCase.run(user);
        } catch (final SignUpUseCaseException ex) {
            switch (ex.errorCode) {
                case SignUpUseCaseException.EMAIL_EXISTS:
                    // Non-exploitable return message.
                    errors.append("Username or email already exists.");
                    break;
                case SignUpUseCaseException.INVALID_ENCRYPTED_PASSWORD:
                    errors.append("Password encryption failed.");
                    break;
                default:
                    break;
            }
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString().trim());
        }

        Map<String, String> response = new HashMap<>();
        response.put("id", user.id().value().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
