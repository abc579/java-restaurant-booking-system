package com.roccatagliatta.restaurant.User.Exceptions;

public final class SignUpUseCaseException extends Exception {

    public final int errorCode;

    public static final int EMAIL_EXISTS = 0;
    public static final int INVALID_ENCRYPTED_PASSWORD = 1;

    public SignUpUseCaseException(int errorCode) {
        this.errorCode = errorCode;
    }

    public static SignUpUseCaseException emailExists() {
        return new SignUpUseCaseException(EMAIL_EXISTS);
    }

    public static SignUpUseCaseException invalidEncryptedPassword() {
        return new SignUpUseCaseException(INVALID_ENCRYPTED_PASSWORD);
    }
}
