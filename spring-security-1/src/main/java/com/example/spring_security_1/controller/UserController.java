package com.example.spring_security_1.controller;

import com.example.spring_security_1.model.User;
import com.example.spring_security_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }
}
