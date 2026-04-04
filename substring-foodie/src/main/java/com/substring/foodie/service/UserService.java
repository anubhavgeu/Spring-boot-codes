package com.substring.foodie.service;

import com.substring.foodie.dto.UserDto;
import com.substring.foodie.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, String userId);
    Page<UserDto> getAllUsers(Pageable pageable);
    List<UserDto> getUsersByName(String username);
    UserDto getUsersByEmail(String email);
    UserDto getUserById(String userId);
    void deleteUser(String userId);
    List<UserDto> searchUserName(String keyword);
//    void testUserRole();
}
