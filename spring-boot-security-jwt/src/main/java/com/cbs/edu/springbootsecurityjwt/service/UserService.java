package com.cbs.edu.springbootsecurityjwt.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cbs.edu.springbootsecurityjwt.model.Role;
import com.cbs.edu.springbootsecurityjwt.model.User;
import com.cbs.edu.springbootsecurityjwt.repository.RoleRepository;
import com.cbs.edu.springbootsecurityjwt.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userEntityRepository;

    @Autowired
    private RoleRepository roleEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User userEntity) {
        Role userRole = roleEntityRepository.findByName("ROLE_USER");
        userEntity.setRoles(Collections.singleton(userRole));
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public User findByLogin(String username) {
        return userEntityRepository.findByUsername(username);
    }

    public User findByLoginAndPassword(String login, String password) {
        User userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityRepository.findByUsername(username);
    }
}
