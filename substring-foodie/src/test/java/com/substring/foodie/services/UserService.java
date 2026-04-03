package com.substring.foodie.services;


import com.substring.foodie.entity.Restaurant;
import com.substring.foodie.entity.Role;
import com.substring.foodie.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserService {
    @Autowired
    private com.substring.foodie.service.UserService userService;
//    @Test
//    public void testSaveUser() {
//        System.out.println("Saving user");
//        User user = new User();
//        user.setName("Anubhav Test1");
//        user.setEmail("test1@gmail.com");
//        user.setAddress("test1 address");
//        user.setPassword("test1pwd");
//        user.setRoles(Role.ADMIN);
//
//        // creating some restaurants;
//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(UUID.randomUUID().toString());
//        restaurant.setName("test1 name restaurant");
//        restaurant.setAddress("test1 address restaurant");
//        restaurant.setOpen(true);
//
//        Restaurant restaurant2 = new Restaurant();
//        restaurant2.setId(UUID.randomUUID().toString());
//        restaurant2.setName("test2 name restaurant");
//        restaurant2.setAddress("test2 address restaurant");
//        restaurant2.setOpen(true);
//
//        restaurant.setUser(user);
//        restaurant2.setUser(user);
//
//        user.getRestaurants().add(restaurant);
//        user.getRestaurants().add(restaurant2);
//
//        User savedUser = userService.saveUser(user);
//        System.out.println(savedUser.getName() + " " + savedUser.getRestaurants());
//
//    }
//
//    @Test
//    public void testUpdateUser() {
//        User user = userService.updateUser();
//        List<Restaurant> restaurants = user.getRestaurants();
//        System.out.println("User updated");
//    }

    @Test
    public void testUpdate() {
        userService.testUserRole();
    }
}
