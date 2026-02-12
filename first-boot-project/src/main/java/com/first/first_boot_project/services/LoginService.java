package com.first.first_boot_project.services;

import com.first.first_boot_project.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public boolean doLogin() {
        loginRepository.getUser();
        // login logic
        return false;
    }
}
