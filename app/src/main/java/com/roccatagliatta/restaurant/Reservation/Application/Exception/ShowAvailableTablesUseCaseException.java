package com.roccatagliatta.restaurant.Reservation.Application.Exception;

public final class ShowAvailableTablesUseCaseException extends Exception {

    public final int errorCode;

    public static final int INTERNAL_ERROR = 0;
    public static final int INVALID_DATE = 1;

    private ShowAvailableTablesUseCaseException(int errorCode) {
        this.errorCode = errorCode;
    }

    public static ShowAvailableTablesUseCaseException invalidDate() {
        return new ShowAvailableTablesUseCaseException(INVALID_DATE);
    }

    public static ShowAvailableTablesUseCaseException internalError() {
        return new ShowAvailableTablesUseCaseException(INTERNAL_ERROR);
    }
}
