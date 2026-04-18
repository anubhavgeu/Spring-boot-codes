package com.substring.foodie.food.service;

import com.substring.foodie.food.dto.FoodCategoryDto;
import com.substring.foodie.food.entities.FoodCategory;
import com.substring.foodie.food.repository.FoodCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class FoodCategoryService {
    FoodCategoryRepo foodCategoryRepo;
    public FoodCategoryService(FoodCategoryRepo foodCategoryRepo) {
        this.foodCategoryRepo = foodCategoryRepo;
    }
    public List<FoodCategoryDto> getAllFoodCategories() {
        return foodCategoryRepo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public FoodCategoryDto getFoodCategoryById(String id) {
        return foodCategoryRepo.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }


    public FoodCategoryDto createFoodCategory(FoodCategoryDto foodCategoryDto) {
        FoodCategory foodCategory = convertToEntity(foodCategoryDto);
        foodCategory.setId(UUID.randomUUID().toString());
        foodCategory = foodCategoryRepo.save(foodCategory);
        return convertToDto(foodCategory);
    }

    public void deleteFoodCategoryById(String id) {
        foodCategoryRepo.deleteById(id);
    }

    private FoodCategoryDto convertToDto(FoodCategory foodCategory) {
        FoodCategoryDto foodCategoryDto = new FoodCategoryDto();
        foodCategoryDto.setId(foodCategory.getId());
        foodCategoryDto.setName(foodCategory.getName());
        foodCategoryDto.setDescription(foodCategory.getDescription());
        return foodCategoryDto;
    }

    private FoodCategory convertToEntity(FoodCategoryDto foodCategoryDto) {
        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setId(foodCategoryDto.getId());
        foodCategory.setName(foodCategoryDto.getName());
        foodCategory.setDescription(foodCategoryDto.getDescription());
        return foodCategory;

    }

}
