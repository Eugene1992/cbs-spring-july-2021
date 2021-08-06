package com.cbs.edu.springbootsecurityjsp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbs.edu.springbootsecurityjsp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
