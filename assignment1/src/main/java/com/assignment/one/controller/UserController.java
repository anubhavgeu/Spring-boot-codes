package com.assignment.one.controller;

import com.assignment.one.entity.User;
import com.assignment.one.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail() + " " + user.getCreateDate() + " " + user.getUpdatedAt());
        System.out.println("Got request to save user");
        return userService.saveUser(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PutMapping("/updateUser/{id}")
    public User updateUserById(@RequestBody User user, @PathVariable int id) {
        return userService.updateUserById(user,id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

}
