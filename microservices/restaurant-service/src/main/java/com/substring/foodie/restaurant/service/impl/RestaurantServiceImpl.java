package com.substring.foodie.restaurant.service.impl;

import com.substring.foodie.restaurant.dto.RestaurantDto;
import com.substring.foodie.restaurant.entities.Restaurant;
import com.substring.foodie.restaurant.repository.RestaurantRepository;
import com.substring.foodie.restaurant.service.RestaurantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    @Override
    public RestaurantDto save(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDto, restaurant);
        restaurant.setId(UUID.randomUUID().toString());
        restaurant = restaurantRepository.save(restaurant);
        BeanUtils.copyProperties(restaurant, restaurantDto);
        return restaurantDto;
    }

    @Override
    public RestaurantDto update(String id, RestaurantDto restaurantDto) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            BeanUtils.copyProperties(restaurantDto, restaurant);
            restaurant = restaurantRepository.save(restaurant);
            BeanUtils.copyProperties(restaurant, restaurantDto);
            return restaurantDto;
        }

        throw new RuntimeException("Restaurant not found with id: " + id);
    }

    @Override
    public RestaurantDto getById(String id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            RestaurantDto restaurantDto = new RestaurantDto();
            BeanUtils.copyProperties(optionalRestaurant.get(), restaurantDto);
            return restaurantDto;
        }
        throw new RuntimeException("Restaurant not found with id: " + id);
    }

    @Override
    @Transactional
    public RestaurantDto findByName(String restaurantName) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findByName(restaurantName);
        if (optionalRestaurant.isPresent()) {
            RestaurantDto restaurantDto = new RestaurantDto();
            BeanUtils.copyProperties(optionalRestaurant.get(), restaurantDto);
            return restaurantDto;
        }
        throw new RuntimeException("Restaurant not found with name: " + restaurantName);
    }

    @Override
    public void delete(String id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<RestaurantDto> getAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            RestaurantDto restaurantDto = new RestaurantDto();
            BeanUtils.copyProperties(restaurant, restaurantDto);
            restaurantDtos.add(restaurantDto);
        }
        return restaurantDtos;
    }
}
