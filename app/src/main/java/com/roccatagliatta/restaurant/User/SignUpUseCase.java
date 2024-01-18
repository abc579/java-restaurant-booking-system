package com.roccatagliatta.restaurant.User;

import com.roccatagliatta.restaurant.PasswordEncryptor.PasswordEncryptor;
import com.roccatagliatta.restaurant.User.Exceptions.SignUpUseCaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class SignUpUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncryptor encryptor;

    public void run(UserId id,
                    UserName name,
                    UserEmail email,
                    UserPassword password,
                    UserType type) throws SignUpUseCaseException {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new SignUpUseCaseException();
        }

        UserPassword encryptedPassword = new UserPassword(encryptor.encrypt(password.value()));

        User user = new User(id, name, email, encryptedPassword, type);

        userRepository.save(user);
    }
}
