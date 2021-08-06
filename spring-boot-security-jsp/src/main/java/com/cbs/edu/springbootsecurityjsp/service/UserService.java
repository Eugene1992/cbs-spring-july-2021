package com.cbs.edu.springbootsecurityjsp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cbs.edu.springbootsecurityjsp.model.Role;
import com.cbs.edu.springbootsecurityjsp.model.User;
import com.cbs.edu.springbootsecurityjsp.repository.RoleRepository;
import com.cbs.edu.springbootsecurityjsp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    public boolean saveUser(User user) {
        User existedUser = userRepository.findByUsername(user.getUsername());

        if (existedUser != null) {
            return false;
        }

        if (user.getUsername().contains("admin")) {
            user.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        } else {
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return true;
    }
}
