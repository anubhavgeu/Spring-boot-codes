package com.assignment.one.service;

import com.assignment.one.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserById(int id);

    List<User> getAllUser();

    User updateUserById(User user, int id);

    String deleteUserById(int id);
}
