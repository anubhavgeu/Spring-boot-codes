package com.mvc.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page");
        String title = "Home Page";
        List<String> userList = List.of("user1", "user24", "user3");
        model.addAttribute("title", title);
        model.addAttribute("userList", userList);
        return "home";
    }
}
