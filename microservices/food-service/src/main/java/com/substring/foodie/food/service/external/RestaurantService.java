package com.substring.foodie.food.service.external;

import com.substring.foodie.food.dto.RestaurantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-service", url = "http://localhost:9091")
public interface RestaurantService {
    // get restaurant with given id
    @GetMapping("/api/v1/restaurants/{id}")
    RestaurantDto findById(@PathVariable("id") String restaurantId);
}
