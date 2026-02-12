package com.first.first_boot_project.controller;

import com.first.first_boot_project.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public String loginPage() {
        System.out.println("This is login page");
        boolean isLogin = loginService.doLogin();
        if (isLogin) {
            return "success_login";
        }
        else {
            return "login";
        }
    }
}
