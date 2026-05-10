package com.substring.foodie.food.service.external.fallback;

import com.substring.foodie.food.dto.RestaurantDto;
import com.substring.foodie.food.service.external.RestaurantService;
import org.springframework.stereotype.Component;

@Component
public class RestaurantServiceFallback implements RestaurantService {
    @Override
    public RestaurantDto findById(String restaurantId) {
        System.out.println("Fallback executed;");
        return null;
    }
}
