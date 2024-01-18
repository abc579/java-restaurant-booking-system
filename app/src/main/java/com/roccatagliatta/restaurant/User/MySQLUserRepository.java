package com.roccatagliatta.restaurant.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public final class MySQLUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<User> findByEmail(UserEmail email) {
        User user = jdbcTemplate.query("select id, username, email, password, type from users where email = ?",
                (rs, rowNum) -> {
                    UserId id = new UserId(rs.getString("id"));
                    UserName name = new UserName(rs.getString("username"));
                    UserEmail emailDb = new UserEmail(rs.getString("email"));
                    UserPassword password = new UserPassword(rs.getString("password"));
                    UserType type = UserType.valueOf(rs.getString("type"));
                    return new User(id, name, emailDb, password, type);
                }, email).get(0);

        return Optional.of(user);
    }

    @Override
    public Optional<User> findById(UserId id) {
        User user = jdbcTemplate.query("select id, username, email, password, type from users where id = ?",
                (rs, rowNum) -> {
                    UserId idDb = new UserId(rs.getString("id"));
                    UserName name = new UserName(rs.getString("username"));
                    UserEmail email = new UserEmail(rs.getString("email"));
                    UserPassword password = new UserPassword(rs.getString("password"));
                    UserType type = UserType.valueOf(rs.getString("type"));
                    return new User(idDb, name, email, password, type);
                }, id).get(0);

        return Optional.of(user);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into users (id, username, email, password, type) values (?, ?, ?, ?, ?)",
                            user.id(),
                            user.username(),
                            user.email(),
                            user.password(),
                            user.type());
    }

}
