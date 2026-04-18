package com.substring.foodie.restaurant.service;

import com.substring.foodie.restaurant.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    RestaurantDto save(RestaurantDto restaurantDto);
    RestaurantDto update(String id, RestaurantDto restaurantDto);
    RestaurantDto getById(String id);
    RestaurantDto findByName(String restaurantName);
    void delete(String id);
    List<RestaurantDto> getAll();
}
