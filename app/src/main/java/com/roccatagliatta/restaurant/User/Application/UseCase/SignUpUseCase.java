package com.roccatagliatta.restaurant.User.Application.UseCase;

import com.roccatagliatta.restaurant.User.Application.UseCase.Exception.SignUpUseCaseException;
import com.roccatagliatta.restaurant.User.Domain.User;
import com.roccatagliatta.restaurant.User.Domain.Persistence.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class SignUpUseCase {

    @Autowired
    private UserRepository userRepository;

    public void run(User user) throws SignUpUseCaseException {
        if (userRepository.findByEmail(user.email()).isPresent()) {
            throw SignUpUseCaseException.emailExists();
        }

        if (userRepository.findByUsername(user.username()).isPresent()) {
            throw SignUpUseCaseException.usernameExists();
        }

        userRepository.save(user);
    }
}
