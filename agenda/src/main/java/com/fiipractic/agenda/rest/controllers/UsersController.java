package com.fiipractic.agenda.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fiipractic.agenda.rest.models.User;
import com.fiipractic.agenda.rest.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{username:.+}")
    public User getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{username:.+}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        return userService.updateUser(username, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{username:.+}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

}
