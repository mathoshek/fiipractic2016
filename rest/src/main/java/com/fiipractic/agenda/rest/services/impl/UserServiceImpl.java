package com.fiipractic.agenda.rest.services.impl;

import com.fiipractic.agenda.rest.models.User;
import com.fiipractic.agenda.rest.services.UserService;
import com.fiipractic.agenda.rest.storage.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * File created by a.chmilevski on 3/14/2016 - 3:24 PM.
 * RadiON
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userDao.add(user);

        return user;
    }

    @Override
    @Transactional
    public User updateUser(String username, User user) {
        User localUser = userDao.getByUsername(username);
        user.setId(localUser.getId());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDao.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        User localUser = userDao.getByUsername(username);
        userDao.delete(localUser);
    }
}
