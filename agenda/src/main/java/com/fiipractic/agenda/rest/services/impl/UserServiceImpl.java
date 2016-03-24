package com.fiipractic.agenda.rest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiipractic.agenda.rest.models.User;
import com.fiipractic.agenda.rest.services.UserService;
import com.fiipractic.agenda.rest.storage.UserDao;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public User createUser(User user) {
        userDao.add(user);
        return user;
    }

    @Override
    public User updateUser(String username, User user) {
        User existingUser = userDao.getByUsername(username);
        user.setId(existingUser.getId());
        return userDao.update(user);
    }

    @Override
    public void deleteUser(String username) {
        User user = userDao.getByUsername(username);
        userDao.delete(user);
    }

}
