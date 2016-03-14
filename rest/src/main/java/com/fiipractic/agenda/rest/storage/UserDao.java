package com.fiipractic.agenda.rest.storage;

import com.fiipractic.agenda.rest.models.User;

import java.util.List;

/**
 * File created by a.chmilevski on 3/14/2016 - 3:25 PM.
 * RadiON
 */
public interface UserDao {

    void add(User user);

    User getById(Long id);

    User update(User user);

    void delete(User user);

    User getByUsername(String username);

    List<User> findAll();

}
