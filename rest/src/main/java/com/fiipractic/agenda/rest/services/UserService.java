package com.fiipractic.agenda.rest.services;

import com.fiipractic.agenda.rest.models.User;

import java.util.List;

/**
 * File created by a.chmilevski on 3/14/2016 - 3:23 PM.
 * RadiON
 */
public interface UserService {
    List<User> getAllUsers();

    User getUserByUsername(String username);

    User createUser(User user);

    User updateUser(String username, User user);

    void deleteUser(String username);
}
