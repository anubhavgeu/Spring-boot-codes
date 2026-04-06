package com.substring.foodie.service;

import com.substring.foodie.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RestaurantService {

    // add
    RestaurantDto addRestaurant(RestaurantDto restaurantDto);
    // get all
    Page<RestaurantDto> getRestaurants(Pageable pageable);

    // get single
    RestaurantDto getRestaurantById(String id);

    // update
    RestaurantDto updateRestaurant(RestaurantDto restaurantDto, String restaurantId);

    // delete
    void deleteRestaurant(String restaurantId);

    List<RestaurantDto> searchByName(String keyword);


    Page<RestaurantDto> getOpenRestaurants(Pageable pageable);

    RestaurantDto uploadBanner(MultipartFile file, String id) throws IOException;
}
