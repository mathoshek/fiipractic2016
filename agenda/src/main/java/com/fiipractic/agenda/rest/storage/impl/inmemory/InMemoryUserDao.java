package com.fiipractic.agenda.rest.storage.impl.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fiipractic.agenda.rest.models.User;
import com.fiipractic.agenda.rest.storage.UserDao;

//@Repository
public class InMemoryUserDao implements UserDao {

    private static Map<String, User> users = new HashMap<>();
    private static long currentMaxUserId = 0;

    @Override
    public void add(User user) {
        user.setId(++currentMaxUserId);
        users.put(user.getUsername(), user);
    }

    @Override
    public User getById(Long id) {
        for (User user : users.values()) {
            if (user.getId().equals(id))
                return user;
        }
        return null;
    }

    @Override
    public User update(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    @Override
    public void delete(User user) {
        users.remove(user.getUsername());
    }

    @Override
    public User getByUsername(String username) {
        return users.get(username);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

}
