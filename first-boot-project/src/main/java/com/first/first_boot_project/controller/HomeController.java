package com.first.first_boot_project.controller;

import com.first.first_boot_project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/magic")
    public String test() {
        productService.createProduct();
        return "This is magic";
    }
    @RequestMapping("/another")
    public String test2() {
        productService.searchProduct();
        return "Done";
    }
}
