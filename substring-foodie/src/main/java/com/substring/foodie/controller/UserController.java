package com.substring.foodie.controller;


import com.substring.foodie.dto.UserDto;
import com.substring.foodie.entity.User;
import com.substring.foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/createUser")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        UserDto savedUserDto = userService.saveUser(userDto);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }


    @GetMapping("/allUser")
    public ResponseEntity<Page<UserDto>> getAllUsers(
            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "createdAt") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "desc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, size, sort);
        return new ResponseEntity<>(userService.getAllUsers(pageable), HttpStatus.OK);
    }

    @GetMapping("/userById/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }






//    @RequestMapping("/")
//    public void getUser1() {
//        System.out.println("Getting user.");
//    }
//
//    @RequestMapping("/get-user")
//    public User getUser() {
//        User user = new User();
//        user.setId(UUID.randomUUID().toString());
//        user.setName("test5");
//        user.setPassword("123456");
//        user.setEmail("test5@gmail.com");
//        user.setAddress("test5 address");
//        user.setAvailable(true);
//        return user;
//    }


}
