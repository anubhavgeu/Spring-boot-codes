package com.first.first_boot_project.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {
    public void getUser() {
        System.out.println("Getting user");
    }
}
