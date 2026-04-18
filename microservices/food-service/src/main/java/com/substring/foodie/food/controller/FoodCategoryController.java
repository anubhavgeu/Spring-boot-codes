package com.substring.foodie.food.controller;


import com.substring.foodie.food.dto.FoodCategoryDto;
import com.substring.foodie.food.entities.FoodCategory;
import com.substring.foodie.food.service.FoodCategoryService;
import com.substring.foodie.food.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-categories")
public class FoodCategoryController {
    private FoodCategoryService foodCategoryService;
    public FoodCategoryController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<FoodCategoryDto>> getAllFoodCategories() {
        return new ResponseEntity<>(foodCategoryService.getAllFoodCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodCategoryDto> getFoodCategory(@PathVariable String id) {
        return  new ResponseEntity<>(foodCategoryService.getFoodCategoryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FoodCategoryDto> createFoodCategory(@RequestBody FoodCategoryDto foodCategoryDto) {
        return new ResponseEntity<>(foodCategoryService.createFoodCategory(foodCategoryDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFoodCategory(@PathVariable String id) {
        foodCategoryService.deleteFoodCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
