package com.substring.foodie.service.impl;

import com.substring.foodie.dto.RestaurantDto;
import com.substring.foodie.entity.Restaurant;
import com.substring.foodie.exception.ResourceNotFoundException;
import com.substring.foodie.repository.RestaurantRepo;
import com.substring.foodie.service.RestaurantService;
import com.substring.foodie.utils.Helper;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepo restaurantRepo;
    private final ModelMapper modelMapper;
    public RestaurantServiceImpl (RestaurantRepo restaurantRepo, ModelMapper modelMapper) {
        this.restaurantRepo = restaurantRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        restaurantDto.setId(Helper.generateRandomId());
        restaurantDto.setCreatedAt(LocalDate.now());
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
        Restaurant savedEntity = restaurantRepo.save(restaurant);
        return modelMapper.map(savedEntity, RestaurantDto.class);
    }

    @Override
    public Page<RestaurantDto> getRestaurants(Pageable pageable) {
        Page<Restaurant> restaurantPage = restaurantRepo.findAll(pageable);
        return restaurantPage.map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class));
    }

    @Override
    public RestaurantDto getRestaurantById(String id) {
        Restaurant restaurant = restaurantRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    @Override
    public RestaurantDto updateRestaurant(RestaurantDto restaurantDto, String restaurantId) {
        Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found!"));
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setDescription(restaurantDto.getDescription());
        restaurant.setCloseTime(restaurantDto.getCloseTime());
        restaurant.setOpenTime(restaurantDto.getOpenTime());
        restaurant.setOpen(restaurantDto.isOpen());
        Restaurant savedRestaurant = restaurantRepo.save(restaurant);
        return modelMapper.map(savedRestaurant, RestaurantDto.class);
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
        Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found!"));
        restaurantRepo.delete(restaurant);
    }

    @Override
    public List<RestaurantDto> searchByName(String keyword) {
        return restaurantRepo.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(restaurant -> modelMapper.map(restaurant,RestaurantDto.class))
                .toList();
    }

    @Override
    public Page<RestaurantDto> getOpenRestaurants(Pageable pageable) {
        Page<Restaurant> pageRestaurant = restaurantRepo.findByIsOpen(true, pageable);
        return pageRestaurant.map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class));
    }
}