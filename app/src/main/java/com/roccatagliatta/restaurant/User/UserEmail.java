package com.roccatagliatta.restaurant.User;

final class UserEmail {
    private static final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private String value;

    public UserEmail(String email) {
        if (email == null || !email.matches(REGEX)) {
            throw new InvalidUserEmailException();
        }

        this.value = email;
    }

    public String value() {
        return value;
    }
}
