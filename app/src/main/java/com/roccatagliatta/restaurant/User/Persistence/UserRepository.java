package com.roccatagliatta.restaurant.User.Persistence;

import java.util.Optional;
import com.roccatagliatta.restaurant.User.Value.UserEmail;
import com.roccatagliatta.restaurant.User.Value.UserName;
import com.roccatagliatta.restaurant.User.Value.UserId;
import com.roccatagliatta.restaurant.User.User;

public interface UserRepository {

    public Optional<User> findByEmail(UserEmail email);

    public Optional<User> findById(UserId id);

    public Optional<User> findByUsername(UserName name);

    public void save(User user);

}
