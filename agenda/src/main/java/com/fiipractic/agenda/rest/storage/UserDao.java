package com.fiipractic.agenda.rest.storage;

import java.util.List;

import com.fiipractic.agenda.rest.models.User;

public interface UserDao {
    public void add(User user);

    public User getById(Long id);

    public User update(User user);

    public void delete(User user);

    public User getByUsername(String username);

    public List<User> findAll();
}
