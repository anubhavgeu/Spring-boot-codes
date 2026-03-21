package com.substring.foodie.substring_foodie.service;

import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.exception.ResourceNotFoundException;
import com.substring.foodie.substring_foodie.repository.UserRepository;
import com.substring.foodie.substring_foodie.security.CustomUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        CustomUserDetail customUserDetail = new CustomUserDetail(user);
        return null;
    }
}
