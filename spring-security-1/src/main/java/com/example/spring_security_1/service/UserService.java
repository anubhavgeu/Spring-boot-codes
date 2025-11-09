package com.example.spring_security_1.service;

import com.example.spring_security_1.model.User;
import com.example.spring_security_1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepo userRepo;
    public User saveUser(User user) {
        user.setPasswords(bCryptPasswordEncoder.encode(user.getPasswords()));
        return userRepo.save(user);
    }
}
