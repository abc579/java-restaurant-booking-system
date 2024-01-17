package com.roccatagliatta.restaurant.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

// @TODO: This approach is not valid if we were to support multiple languages.
public record SignUpRequest(@NotNull @NotEmpty String username,
                            @NotNull @NotEmpty String email,
                            @NotNull @NotEmpty String password) {
}
