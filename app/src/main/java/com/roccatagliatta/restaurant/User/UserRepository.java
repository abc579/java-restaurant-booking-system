package com.roccatagliatta.restaurant.User;

import java.util.Optional;

public interface UserRepository {

    public Optional<User> findByEmail(UserEmail email);

    public Optional<User> findById(UserId id);

    public void save(User user);

}
