package com.substring.foodie.controller;


import com.substring.foodie.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @RequestMapping("/")
    public void getUser1() {
        System.out.println("Getting user.");
    }

    @RequestMapping("/get-user")
    public User getUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("test5");
        user.setPassword("123456");
        user.setEmail("test5@gmail.com");
        user.setAddress("test5 address");
        user.setAvailable(true);
        return user;
    }
}
