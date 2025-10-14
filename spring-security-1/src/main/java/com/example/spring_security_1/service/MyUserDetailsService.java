package com.example.spring_security_1.service;

import com.example.spring_security_1.model.User;
import com.example.spring_security_1.dao.UserRepo;
import com.example.spring_security_1.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repo.findByUsername(username);
        if (user == null) {
            System.out.println("404");
            throw new UsernameNotFoundException("User 404");
        }
        else {

        }
        return new UserPrincipal(user);
    }
}
