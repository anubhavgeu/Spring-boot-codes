package com.substring.foodie.service.impl;

import com.substring.foodie.entity.Restaurant;
import com.substring.foodie.entity.RoleEntity;
import com.substring.foodie.entity.User;
import com.substring.foodie.repository.UserRepo;
import com.substring.foodie.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User updateUser() {
        // getUser then update it;
        // add a new restaurant in it;
        User user1 = userRepo.findById("405b0cfa-3423-4712-9c09-cf2273bc5c90").orElseThrow();
        Restaurant restaurant3 = new Restaurant();
        restaurant3.setId(UUID.randomUUID().toString());
        restaurant3.setName("test3 name restaurant");
        restaurant3.setAddress("test3 address restaurant");
        restaurant3.setOpen(true);
        restaurant3.setUser(user1);
        user1.getRestaurants().add(restaurant3);
        User savedUser = userRepo.save(user1);
        return savedUser;
    }

    @Override
    public void testUserRole() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("test4 with role");
        user.setEmail("test4@gmail.com");
        user.setAvailable(true);
        user.setAddress("test4 address");
        user.setPassword("test4pwd");

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("ROLE_ADMIN");

        RoleEntity roleEntity2 = new RoleEntity();
        roleEntity2.setName("ROLE_GUEST");

        //link from user
        user.getRoleEntities().add(roleEntity);
        user.getRoleEntities().add(roleEntity2);
        // link from entity
        roleEntity.getUserList().add(user);
        roleEntity2.getUserList().add(user);

        userRepo.save(user);
        System.out.println("User saved");

    }
}
