package com.cbs.edu.springbootsecurityjsp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbs.edu.springbootsecurityjsp.model.Role;
import com.cbs.edu.springbootsecurityjsp.model.User;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
