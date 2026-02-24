package com.substring.foodie.substring_foodie.services;

import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.entity.Role;
import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserService {

    @Autowired
    private com.substring.foodie.substring_foodie.service.UserService userService;

//    @Test
//    public void saveUserTest(){
//        System.out.println("Saving user...");
//        User user = new User();
//        user.setName("Anubhav Singh");
//        user.setPassword("Anubhav");
//        user.setAddress("Seer goverdhan pur BHU ");
//        user.setEmail("anubhav860102@gmail.com");
//        user.setIsAvailable(true);
//        user.setRole(Role.ADMIN);
//
//        // restaurant
//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(UUID.randomUUID().toString());
//        restaurant.setName("KFC");
//        restaurant.setAddress("BHU");
//        restaurant.setIsOpen(true);
//
//        Restaurant restaurant2 = new Restaurant();
//        restaurant2.setId(UUID.randomUUID().toString());
//        restaurant2.setName("DOMINOS");
//        restaurant2.setAddress("Lanka");
//        restaurant2.setIsOpen(true);
//
//        restaurant.setUser(user);
//        restaurant2.setUser(user);
//
//        user.getRestaurantList().add(restaurant);
//        user.getRestaurantList().add(restaurant2);
//
//        User savedUser = userService.saveUser(user);
//        System.out.println(savedUser + " id of user is: " + savedUser.getId());
//    }

    @Test
    public void testUpdateUser(){
        System.out.println("Updating user...");

//        User user = userService.updateUser();
//        System.out.println("User name: " + user.getName());
//        System.out.println("User updated");
            userService.testUserRole();
    }
}
