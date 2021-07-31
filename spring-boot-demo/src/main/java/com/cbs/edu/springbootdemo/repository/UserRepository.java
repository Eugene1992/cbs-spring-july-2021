package com.cbs.edu.springbootdemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cbs.edu.springbootdemo.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM users u WHERE u.password = :password", nativeQuery = true)
    User getMeUserRightNowByPasswordd(String password);
}
