package com.assignment.one.service;

import com.assignment.one.dao.UserRepository;
import com.assignment.one.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user) {
        user.setUpdatedAt(LocalDate.now());
        return userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserById(User user, int id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//        existingUser.setId(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUpdatedAt(LocalDate.now());
        return userRepository.save(existingUser);
    }

    @Override
    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "Sucessfully processed";
    }
}
