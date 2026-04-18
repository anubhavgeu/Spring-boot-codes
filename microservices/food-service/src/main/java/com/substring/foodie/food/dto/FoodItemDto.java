package com.substring.foodie.food.dto;

import com.substring.foodie.food.entities.FoodType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemDto {
    private String id;
    private String title;
    private String description;
    private int quantity;
    private boolean outOfStock;
    private FoodType foodType;
    private String foodCategoryId;
    private FoodCategoryDto foodCategoryDto;
    private String restaurantId;
    private RestaurantDto restaurantDto;
}

