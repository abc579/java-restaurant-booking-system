package com.roccatagliatta.restaurant.Security;

import java.util.Optional;

import com.roccatagliatta.restaurant.User.User;
import com.roccatagliatta.restaurant.User.Exceptions.InvalidUserNameException;
import com.roccatagliatta.restaurant.User.Persistence.UserRepository;
import com.roccatagliatta.restaurant.User.Value.UserName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        // TODO: This part is a mess.
        try {
            UserName userName = new UserName(username);
            Optional<User> user = userRepository.findByUsername(userName);
            if (user.isEmpty()) {
                return null;
            }
            return UserDetailsImpl.build(user.get());
        } catch (final InvalidUserNameException ex) {
            return null;
        }
    }
}
