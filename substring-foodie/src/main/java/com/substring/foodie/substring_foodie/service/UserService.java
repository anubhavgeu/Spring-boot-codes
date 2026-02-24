package com.substring.foodie.substring_foodie.service;

import com.substring.foodie.substring_foodie.dto.UserDto;
import com.substring.foodie.substring_foodie.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, String userId);
    void testUserRole();
    List<UserDto> getAll();
    List<UserDto> getUserByName(String userName);
    UserDto getUserByEmail(String email);
    UserDto getUserById(String userId);
    void deleteUser(String userId);
    List<UserDto> searchUserName(String keyword);
}
