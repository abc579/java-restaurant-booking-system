package com.roccatagliatta.restaurant.User.Infrastructure.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.roccatagliatta.restaurant.User.Domain.Value.*;
import com.roccatagliatta.restaurant.User.Domain.User;
import com.roccatagliatta.restaurant.User.Domain.Persistence.UserRepository;

@Service
public final class MySQLUserRepository implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<User> findByEmail(UserEmail email) {
        List<User> users = jdbcTemplate.query("select id, username, email, password, type from users where email = ?",
                (rs, rowNum) -> {
                    try {
                        UserId id = new UserId(rs.getString("id"));
                        UserName name = new UserName(rs.getString("username"));
                        UserEmail emailDb = new UserEmail(rs.getString("email"));
                        UserPassword password = UserPassword.fromEncrypted(rs.getString("password"));
                        UserType type = UserType.valueOf(Integer.parseInt(rs.getString("type")));
                        return new User(id, name, emailDb, password, type);
                    } catch (final Exception ex) {
                        return null;
                    }
                }, email.value());

        return users.isEmpty() ? Optional.empty() : Optional.ofNullable(users.get(0));
    }

    @Override
    public Optional<User> findByUsername(UserName name) {
        List<User> users = jdbcTemplate.query(
                "select id, username, email, password, type from users where username = ?",
                (rs, rowNum) -> {
                    try {
                        UserId id = new UserId(rs.getString("id"));
                        UserName nameDb = new UserName(rs.getString("username"));
                        UserEmail email = new UserEmail(rs.getString("email"));
                        UserPassword password = UserPassword.fromEncrypted(rs.getString("password"));
                        UserType type = UserType.valueOf(Integer.parseInt(rs.getString("type")));
                        return new User(id, nameDb, email, password, type);
                    } catch (final Exception ex) {
                        return null;
                    }
                }, name.value());

        return users.isEmpty() ? Optional.empty() : Optional.ofNullable(users.get(0));
    }

    @Override
    public Optional<User> findById(UserId id) {
        List<User> users = jdbcTemplate.query("select id, username, email, password, type from users where id = ?",
                (rs, rowNum) -> {
                    try {
                        UserId idDb = new UserId(rs.getString("id"));
                        UserName name = new UserName(rs.getString("username"));
                        UserEmail email = new UserEmail(rs.getString("email"));
                        UserPassword password = UserPassword.fromEncrypted(rs.getString("password"));
                        UserType type = UserType.valueOf(Integer.parseInt(rs.getString("type")));
                        return new User(idDb, name, email, password, type);
                    } catch (final Exception ex) {
                        return null;
                    }
                }, id.value().toString());

        return users == null ? Optional.empty() : Optional.of(users.get(0));
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into users (id, username, email, password, type) values (?, ?, ?, ?, ?)",
                user.id().value().toString(),
                user.username().value(),
                user.email().value(),
                user.password().value(),
                user.type().value());
    }

}
