package com.roccatagliatta.restaurant.User;

import java.util.List;
import java.util.UUID;

public record SignInResponse(UUID id, String username, String password, List<String> roles) {

}
