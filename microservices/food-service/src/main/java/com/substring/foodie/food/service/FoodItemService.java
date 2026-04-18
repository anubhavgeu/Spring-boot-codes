package com.substring.foodie.food.service;

import com.substring.foodie.food.dto.FoodCategoryDto;
import com.substring.foodie.food.dto.FoodItemDto;
import com.substring.foodie.food.dto.RestaurantDto;
import com.substring.foodie.food.entities.FoodCategory;
import com.substring.foodie.food.entities.FoodItem;
import com.substring.foodie.food.repository.FoodCategoryRepo;
import com.substring.foodie.food.repository.FoodItemRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodItemService {
    private final FoodItemRepo foodItemRepo;
    private final FoodCategoryRepo foodCategoryRepo;
    private final RestTemplate restTemplate;
    public FoodItemService(FoodItemRepo foodItemRepo, FoodCategoryRepo foodCategoryRepo, RestTemplate restTemplate) {
        this.foodItemRepo = foodItemRepo;
        this.foodCategoryRepo = foodCategoryRepo;
        this.restTemplate = restTemplate;
    }

    public List<FoodItemDto> getAllFoodItems() {
        return foodItemRepo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public FoodItemDto getFoodItemById(String foodItemId) {
//        return foodItemRepo.findById(foodItemId)
//                .map(this::convertToDto)
//                .orElse(null);
        FoodItem foodItem = foodItemRepo.findById(foodItemId).orElseThrow(()->new RuntimeException("FoodItem not found"));
        // food item ke andar category + restaurant h;
        // call restaurant service to get the data
        String restaurantServiceUrl = "http://localhost:9091/api/v1/restaurants/" + foodItem.getRestaurantId();
        RestaurantDto restaurantDto = restTemplate.getForObject(restaurantServiceUrl, RestaurantDto.class);
        FoodItemDto foodItemDto = convertToDto(foodItem);
        foodItemDto.setRestaurantDto(restaurantDto);
        return foodItemDto;
    }

    public FoodItemDto createFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItem = convertToEntity(foodItemDto);
        foodItem.setId(UUID.randomUUID().toString());
        FoodCategory foodCategory = foodCategoryRepo.findById(foodItemDto.getFoodCategoryId()).orElseThrow(() -> new RuntimeException("FoodCategory not found"));
        foodItem.setFoodCategory(foodCategory);
        foodItem = foodItemRepo.save(foodItem);
        return convertToDto(foodItem);
    }

    public void deleteFoodItemById(String foodItemId) {
        foodItemRepo.deleteById(foodItemId);
    }

    private FoodItemDto convertToDto(FoodItem foodItem) {
        FoodItemDto foodItemDto = new FoodItemDto();
        foodItemDto.setId(foodItem.getId());
        foodItemDto.setTitle(foodItem.getTitle());
        foodItemDto.setDescription(foodItem.getDescription());
        foodItemDto.setQuantity(foodItem.getQuantity());
        foodItemDto.setOutOfStock(foodItem.isOutOfStock());
        foodItemDto.setFoodType(foodItem.getFoodType());
        foodItemDto.setFoodCategoryId(foodItem.getFoodCategory().getId());
        FoodCategoryDto foodCategoryDto  = new FoodCategoryDto();
        foodCategoryDto.setId(foodItem.getFoodCategory().getId());
        foodCategoryDto.setName(foodItem.getFoodCategory().getName());
        foodCategoryDto.setDescription(foodItem.getFoodCategory().getDescription());
        foodItemDto.setFoodCategoryDto(foodCategoryDto);
        foodItemDto.setRestaurantId(foodItem.getRestaurantId());
        return foodItemDto;
    }

    private FoodItem convertToEntity(FoodItemDto foodItemDto) {
        FoodItem foodItem = new FoodItem();
        foodItem.setId(foodItemDto.getId());
        foodItem.setTitle(foodItemDto.getTitle());
        foodItem.setDescription(foodItemDto.getDescription());
        foodItem.setQuantity(foodItemDto.getQuantity());
        foodItem.setOutOfStock(foodItemDto.isOutOfStock());
        foodItem.setFoodType(foodItemDto.getFoodType());
        foodItem.setRestaurantId(foodItemDto.getRestaurantId());
        return  foodItem;
    }

}
