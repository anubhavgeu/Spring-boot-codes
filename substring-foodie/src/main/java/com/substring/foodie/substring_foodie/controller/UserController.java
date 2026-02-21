package com.substring.foodie.substring_foodie.controller;


import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
//    @RequestMapping("/")
//    public String getUser() {
//        System.out.println("Getting User");
//        return "Get User";
//    }

    @RequestMapping("/player-list")
    public List<String> getPlayerList() {
        List<String> playerList = new ArrayList<>();
        playerList.add("Rohit");
        playerList.add("Robin");
        playerList.add("Sachin");
        playerList.add("Kohli");
        playerList.add("Bumrah");
        return playerList;
    }

    @RequestMapping("/get-user")
    public User getUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("Sachin");
        user.setPassword("123456");
        user.setEmail("avs@gmail.com");
        user.setRestaurantList(List.of(new Restaurant()));
        user.setIsAvailable(true);
        user.setAddress("New delhi");
        return user;
    }
}
