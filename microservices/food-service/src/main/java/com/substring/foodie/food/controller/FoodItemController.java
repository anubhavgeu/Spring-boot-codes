package com.substring.foodie.food.controller;


import com.substring.foodie.food.dto.FoodItemDto;
import com.substring.foodie.food.service.FoodItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-item")


public class FoodItemController {
    private FoodItemService foodItemService;
    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }
    @GetMapping
    public List<FoodItemDto> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/{id}")
    public FoodItemDto getFoodItem(@PathVariable String id) {
        return foodItemService.getFoodItemById(id);
    }

    @PostMapping
    public FoodItemDto createFoodItem(@RequestBody FoodItemDto foodItemDto) {
        return foodItemService.createFoodItem(foodItemDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFoodItem(@PathVariable String id) {
        foodItemService.deleteFoodItemById(id);
    }

}
