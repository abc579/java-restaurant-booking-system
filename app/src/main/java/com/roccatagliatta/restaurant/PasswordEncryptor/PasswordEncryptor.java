package com.roccatagliatta.restaurant.PasswordEncryptor;

public interface PasswordEncryptor {

    public String encrypt(String plain);

    public boolean compare(String plainPassword, String encrypted);

}
