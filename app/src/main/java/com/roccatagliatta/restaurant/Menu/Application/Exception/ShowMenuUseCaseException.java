package com.roccatagliatta.restaurant.Menu.Application.Exception;

public final class ShowMenuUseCaseException extends Exception {

    public final int errorCode;

    public static final int INVALID_YEAR = 0;
    public static final int INVALID_MONTH = 1;
    public static final int INVALID_WEEK = 2;

    private ShowMenuUseCaseException(int errorCode) {
        this.errorCode = errorCode;
    }

    public static ShowMenuUseCaseException invalidYear() {
        return new ShowMenuUseCaseException(INVALID_YEAR);
    }

    public static ShowMenuUseCaseException invalidMonth() {
        return new ShowMenuUseCaseException(INVALID_MONTH);
    }

    public static ShowMenuUseCaseException invalidWeek() {
        return new ShowMenuUseCaseException(INVALID_WEEK);
    }
}
