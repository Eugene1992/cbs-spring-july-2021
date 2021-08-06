package com.cbs.edu.springbootdemo.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.edu.springbootdemo.model.User;
import com.cbs.edu.springbootdemo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Collection<User> getAllUsers(@RequestParam Integer page,
                                        @RequestParam Integer size,
                                        @RequestParam String username) {
        return userService.getAllByUsername(username, page, size);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PostMapping
    public void createUser(@RequestBody @Valid User user) {
        userService.create(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @GetMapping(value = "/search")
    public User getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @GetMapping(value = "/searchByPassword")
    public User getByPassword(@RequestParam String password) {
        return userService.getByPassword(password);
    }

    @GetMapping(value = "/doSomething")
    public void doSomething() {
        userService.doSomething();
    }
}
