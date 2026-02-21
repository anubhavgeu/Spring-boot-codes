package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.entity.Role;
import com.substring.foodie.substring_foodie.entity.RoleEntity;
import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.repository.UserRepository;
import com.substring.foodie.substring_foodie.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    // constructor injection;
    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        User savedEntity = userRepository.save(user);
        return savedEntity;
    }


    @Transactional
    public User updateUser(User user, String userId) {
        // get user,
        // then add new Restaurant in it;
        User byId = userRepository.findById(userId).orElseThrow(() ->new RuntimeException("User doesn't exist"));
        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.randomUUID().toString());
        restaurant.setName("Varista");
        restaurant.setAddress("Delhi");
        restaurant.setIsOpen(false);

        restaurant.setUser(byId);
        byId.getRestaurantList().add(restaurant);
        User savedUser = userRepository.save(byId);
        return savedUser;
    }

    @Override
    public void testUserRole() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("Test 123");
        user.setEmail("test@mail.com");
        user.setIsAvailable(true);
        user.setAddress("test address");
        user.setPassword("123");

        RoleEntity roleEntity1 = new RoleEntity();
        roleEntity1.setName("ROLE_ADMIN");
        RoleEntity roleEntity2 = new RoleEntity();
        roleEntity2.setName("ROLE_USER");

        // link
        user.getRoleEntities().add(roleEntity1);
        user.getRoleEntities().add(roleEntity2);

        roleEntity1.getUsers().add(user);
        roleEntity2.getUsers().add(user);

        userRepository.save(user);
        System.out.println("User saved successfully");
    }
}
