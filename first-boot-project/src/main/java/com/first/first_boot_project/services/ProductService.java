package com.first.first_boot_project.services;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public void createProduct() {
        System.out.println("Creating product");
        System.out.println("Product created");
    }

    public void getProduct() {
        System.out.println("Getting product");
        System.out.println("Got");
    }

    public void searchProduct() {
        System.out.println("Searching product");
        System.out.println("Searched");
    }
}
