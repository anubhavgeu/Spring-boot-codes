package com.substring.foodie.food.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodCategoryDto {
    private String id;
    private String name;
    private String description;
    private List<FoodItemDto> foodItems;
}
