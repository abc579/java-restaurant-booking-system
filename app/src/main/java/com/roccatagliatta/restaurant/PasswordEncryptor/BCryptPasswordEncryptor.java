package com.roccatagliatta.restaurant.PasswordEncryptor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class BCryptPasswordEncryptor implements PasswordEncryptor {

    @Override
    public boolean compare(String plainPassword, String encrypted) {
        final String plain = encrypt(plainPassword);

        return plain.equals(encrypted);
    }

    @Override
    public String encrypt(String plain) {
        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(plain).toString();
    }

}
