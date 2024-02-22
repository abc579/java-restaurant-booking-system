package com.roccatagliatta.restaurant.User.Application.UseCase.Exception;

public final class SignInUseCaseException extends Exception {

    public final int errorCode;

    public static final int BAD_CREDENTIALS = 0;

    private SignInUseCaseException(int errorCode) {
        this.errorCode = errorCode;
    }

    public static SignInUseCaseException badCredentials() {
        return new SignInUseCaseException(BAD_CREDENTIALS);
    }
}
