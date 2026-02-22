package com.substring.foodie.substring_foodie.controller.example;

import com.substring.foodie.substring_foodie.playload.example.UserData;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    //login
    @RequestMapping("/login")
    public List<String> login(@RequestBody List<String> list) {
        logger.info("List: {}", list);
        return list;
    }
    // register
    @RequestMapping("/signup")
    public String signup(@Valid @RequestBody UserData userData) {
        logger.info("Going to signup");
        logger.info("Username: {}", userData.getName());
        logger.info("Password: {}", userData.getPassword());
        logger.info("Email: {}", userData.getEmail());
        logger.info("age: {}", userData.getAge());
        return "Got the data";
    }
}
