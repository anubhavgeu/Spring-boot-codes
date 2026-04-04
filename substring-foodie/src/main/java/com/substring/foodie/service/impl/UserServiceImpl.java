package com.substring.foodie.service.impl;

import com.substring.foodie.dto.UserDto;
import com.substring.foodie.entity.User;
import com.substring.foodie.exception.ResourceNotFoundException;
import com.substring.foodie.repository.UserRepo;
import com.substring.foodie.service.UserService;
import com.substring.foodie.utils.Helper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        // generate new Id for user;
        userDto.setId(Helper.generateRandomId());
        // cast dto to entity;
        User user = convertDtoToUserEntity(userDto);
        User savedUser = userRepo.save(user);
        return convertUserEntityToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        return null;
    }

    @Override
    public Page<UserDto> getAllUsers(Pageable pageable) {
        Page<User> userPage = userRepo.findAll(pageable);
        return userPage.map(user -> convertUserEntityToDto(user));
    }

    @Override
    public List<UserDto> getUsersByName(String username) {
        return userRepo.findByName(username)
                .stream()
                .map((user) -> convertUserEntityToDto((User) user)).toList();
    }

    @Override
    public UserDto getUsersByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found."));
        return convertUserEntityToDto(user);
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepo
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found!!!"));

        return convertUserEntityToDto(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<UserDto> searchUserName(String keyword) {
        return List.of();
    }


    private User convertDtoToUserEntity(UserDto userDto) {
        User user = new User();
//        BeanUtils.copyProperties(userDto, user);
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

    private UserDto convertUserEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }


//    @Override
//    public User saveUser(User user) {
//        user.setId(UUID.randomUUID().toString());
//        return userRepo.save(user);
//    }
//
//    @Override
//    @Transactional
//    public User updateUser() {
//        // getUser then update it;
//        // add a new restaurant in it;
//        User user1 = userRepo.findById("405b0cfa-3423-4712-9c09-cf2273bc5c90").orElseThrow();
//        Restaurant restaurant3 = new Restaurant();
//        restaurant3.setId(UUID.randomUUID().toString());
//        restaurant3.setName("test3 name restaurant");
//        restaurant3.setAddress("test3 address restaurant");
//        restaurant3.setOpen(true);
//        restaurant3.setUser(user1);
//        user1.getRestaurants().add(restaurant3);
//        User savedUser = userRepo.save(user1);
//        return savedUser;
//    }
//
//    @Override
//    public void testUserRole() {
//        User user = new User();
//        user.setId(UUID.randomUUID().toString());
//        user.setName("test4 with role");
//        user.setEmail("test4@gmail.com");
//        user.setAvailable(true);
//        user.setAddress("test4 address");
//        user.setPassword("test4pwd");
//
//        RoleEntity roleEntity = new RoleEntity();
//        roleEntity.setName("ROLE_ADMIN");
//
//        RoleEntity roleEntity2 = new RoleEntity();
//        roleEntity2.setName("ROLE_GUEST");
//
//        //link from user
//        user.getRoleEntities().add(roleEntity);
//        user.getRoleEntities().add(roleEntity2);
//        // link from entity
//        roleEntity.getUserList().add(user);
//        roleEntity2.getUserList().add(user);
//
//        userRepo.save(user);
//        System.out.println("User saved");
//
//    }
}
