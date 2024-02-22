package com.roccatagliatta.restaurant.User.Domain.Persistence;

import java.util.Optional;
import com.roccatagliatta.restaurant.User.Domain.Value.UserEmail;
import com.roccatagliatta.restaurant.User.Domain.Value.UserName;
import com.roccatagliatta.restaurant.User.Domain.Value.UserId;
import com.roccatagliatta.restaurant.User.Domain.User;

public interface UserRepository {

    public Optional<User> findByEmail(UserEmail email);

    public Optional<User> findById(UserId id);

    public Optional<User> findByUsername(UserName name);

    public void save(User user);

}
