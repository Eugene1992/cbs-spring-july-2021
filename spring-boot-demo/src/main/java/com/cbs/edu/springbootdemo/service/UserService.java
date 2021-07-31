package com.cbs.edu.springbootdemo.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.cbs.edu.springbootdemo.model.User;
import com.cbs.edu.springbootdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements GenericService<User, Integer> {

    private final UserRepository repository;

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public User get(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Collection<User> getAll() {
        Collection<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);

        return users;
    }

    public User getByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User getByPassword(String password) {
        return repository.getMeUserRightNowByPasswordd(password);
    }
}
