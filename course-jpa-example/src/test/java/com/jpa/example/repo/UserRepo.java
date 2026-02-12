package com.jpa.example.repo;


import com.jpa.example.entities.User;
import com.jpa.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRepo {

    @Autowired
    public UserRepository userRepository;

    @Test
    public void test1() {
        Optional<User> byId = userRepository.findById(10101);
        byId.ifPresentOrElse(user -> {
            System.out.println(user.getUserId());
            System.out.println(user.getName());
            System.out.println(user.getEmail());
        }, () -> {
            System.out.println("User not found!!!");
        });
    }
}
