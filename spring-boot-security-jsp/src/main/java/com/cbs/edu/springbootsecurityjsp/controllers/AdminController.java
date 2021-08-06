package com.cbs.edu.springbootsecurityjsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cbs.edu.springbootsecurityjsp.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "admin";
    }
}
