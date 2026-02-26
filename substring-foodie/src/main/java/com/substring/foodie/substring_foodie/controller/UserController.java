package com.substring.foodie.substring_foodie.controller;


import com.substring.foodie.substring_foodie.dto.UserDto;
import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
//    @RequestMapping("/")
//    public String getUser() {
//        System.out.println("Getting User");
//        return "Get User";
//    }

//    @RequestMapping("/player-list")
//    public List<String> getPlayerList() {
//        String template = null;
//        template.length();
//        List<String> playerList = new ArrayList<>();
//        playerList.add("Rohit");
//        playerList.add("Robin");
//        playerList.add("Sachin");
//        playerList.add("Kohli");
//        playerList.add("Bumrah");
//        return playerList;
//    }
//
//    @RequestMapping("/get-user")
//    public User getUser() {
//        User user = new User();
//        user.setId(UUID.randomUUID().toString());
//        user.setName("Sachin");
//        user.setPassword("123456");
//        user.setEmail("avs@gmail.com");
//        user.setRestaurantList(List.of(new Restaurant()));
//        user.setIsAvailable(true);
//        user.setAddress("New delhi");
//        return user;
//    }


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto userDtoResult = userService.saveUser(userDto);
//        return ResponseEntity.ok(userDtoResult);
        return new ResponseEntity<>(userDtoResult, HttpStatus.CREATED);
    }

    // getALl User;
    @GetMapping("/")
    public ResponseEntity<Page<UserDto>> findAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "createdAt") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "desc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<UserDto> userDtoList = userService.getAll(pageable);
        return new ResponseEntity<>(userDtoList,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable("userId") String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
