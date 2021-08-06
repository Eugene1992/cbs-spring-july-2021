package com.cbs.edu.springbootdemo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cbs.edu.springbootdemo.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM users u WHERE u.password = :password", nativeQuery = true)
    User getMeUserRightNowByPasswordd(String password);

    List<User> findAllByUsername(String username, Pageable pageable);
}
