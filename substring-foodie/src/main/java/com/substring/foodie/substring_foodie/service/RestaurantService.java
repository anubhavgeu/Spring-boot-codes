package com.substring.foodie.substring_foodie.service;

import com.substring.foodie.substring_foodie.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {
    // add
    RestaurantDto add(RestaurantDto restaurantDto);
    RestaurantDto update(RestaurantDto restaurantDto, String id);
    void delete(String delete);
    RestaurantDto getById(String id);
    Page<RestaurantDto> getAll(Pageable pageable);
    List<RestaurantDto> searchByName(String keyword);
    // add more services;
    // get restaurant which are open now;
    Page<RestaurantDto> getOpenRestaurant(Pageable pageable);
}
