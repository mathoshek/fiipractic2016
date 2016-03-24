package com.fiipractic.agenda.rest.services;

import java.util.List;

import com.fiipractic.agenda.rest.models.User;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserByUsername(String username);

    public User createUser(User user);

    public User updateUser(String username, User user);

    public void deleteUser(String username);
}