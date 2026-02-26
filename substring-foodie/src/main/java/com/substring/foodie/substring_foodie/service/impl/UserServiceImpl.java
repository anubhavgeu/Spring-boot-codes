package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.dto.UserDto;
import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.entity.Role;
import com.substring.foodie.substring_foodie.entity.RoleEntity;
import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.exception.ResourceNotFoundException;
import com.substring.foodie.substring_foodie.repository.UserRepository;
import com.substring.foodie.substring_foodie.service.UserService;
import com.substring.foodie.substring_foodie.utils.Helper;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.util.BeanUtil;

import java.util.List;
import java.util.Optional;import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    // constructor injection;
    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        // generate new id for user;
        userDto.setId(Helper.generateRandomId());
        User user = convertUserDtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return convertUserToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null;
    }

    @Override
    public void testUserRole() {

    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(this::convertUserToUserDto)
//                .toList();
        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage.map(user -> convertUserToUserDto(user));
    }

    @Override
    public List<UserDto> getUserByName(String userName) {
        return userRepository.findByName(userName).stream().map(
                user -> convertUserToUserDto(user)
        ).toList();
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User Not found!!"));
        return convertUserToUserDto(user);
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found!!"));
        return convertUserToUserDto(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> searchUserName(String keyword) {
        return List.of();
    }

    private User convertUserDtoToUser(UserDto userDto) {
        User user = new User();
//        BeanUtils.copyProperties(userDto,user);
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAddress(userDto.getAddress());
        return user;
    }
    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
//    @Override
//    public User saveUser(User user) {
//        user.setId(UUID.randomUUID().toString());
//        User savedEntity = userRepository.save(user);
//        return savedEntity;
//    }
//
//
//    @Transactional
//    public User updateUser(User user, String userId) {
//        // get user,
//        // then add new Restaurant in it;
//        User byId = userRepository.findById(userId).orElseThrow(() ->new RuntimeException("User doesn't exist"));
//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(UUID.randomUUID().toString());
//        restaurant.setName("Varista");
//        restaurant.setAddress("Delhi");
//        restaurant.setIsOpen(false);
//
//        restaurant.setUser(byId);
//        byId.getRestaurantList().add(restaurant);
//        User savedUser = userRepository.save(byId);
//        return savedUser;
//    }
//
//    @Override
//    public void testUserRole() {
//        User user = new User();
//        user.setId(UUID.randomUUID().toString());
//        user.setName("Test 123");
//        user.setEmail("test@mail.com");
//        user.setIsAvailable(true);
//        user.setAddress("test address");
//        user.setPassword("123");
//
//        RoleEntity roleEntity1 = new RoleEntity();
//        roleEntity1.setName("ROLE_ADMIN");
//        RoleEntity roleEntity2 = new RoleEntity();
//        roleEntity2.setName("ROLE_USER");
//
//        // link
//        user.getRoleEntities().add(roleEntity1);
//        user.getRoleEntities().add(roleEntity2);
//
//        roleEntity1.getUsers().add(user);
//        roleEntity2.getUsers().add(user);
//
//        userRepository.save(user);
//        System.out.println("User saved successfully");
//    }
}
