package com.cbs.edu.springbootdemo.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Collection<User> getAllByUsername(String username,
                                             Integer page,
                                             Integer size) {
        return repository.findAllByUsername(username, PageRequest.of(page, size));
    }

    public User getByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User getByPassword(String password) {
        return repository.getMeUserRightNowByPasswordd(password);
    }

    @Transactional
    public void doSomething() {
        User firstUser = repository.findById(1).get();
        firstUser.setPassword("XXX");
        repository.save(firstUser);

        if (true) {
            throw new RuntimeException();
        }

        User secondUser = repository.findById(2).get();
        secondUser.setPassword("XXX");
        repository.save(secondUser);
    }
}
