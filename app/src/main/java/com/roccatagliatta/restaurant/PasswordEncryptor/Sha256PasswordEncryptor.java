package com.roccatagliatta.restaurant.PasswordEncryptor;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

import org.springframework.stereotype.Service;

@Service
public final class Sha256PasswordEncryptor implements PasswordEncryptor {

    @Override
    public boolean compare(String plainPassword, String encrypted) {
        final String plain = encrypt(plainPassword);

        return plain.equals(encrypted);
    }

    @Override
    public String encrypt(String plain) {
        return Hashing.sha256().hashString(plain, StandardCharsets.UTF_8).toString();
    }

}
