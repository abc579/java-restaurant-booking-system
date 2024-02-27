package com.roccatagliatta.restaurant.Menu.Application.Exception;

public final class ShowMenuUseCaseException extends Exception {

    public final int errorCode;

    public static final int INVALID_DATE = 0;

    private ShowMenuUseCaseException(int errorCode) {
        this.errorCode = errorCode;
    }

    public static ShowMenuUseCaseException invalidDate() {
        return new ShowMenuUseCaseException(INVALID_DATE);
    }
}
