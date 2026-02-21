package com.substring.foodie.substring_foodie.service;

import com.substring.foodie.substring_foodie.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User saveUser(User user);
    User updateUser(User user, String userId);
    void testUserRole();
}
