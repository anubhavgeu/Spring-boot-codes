package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.dto.FileData;
import com.substring.foodie.substring_foodie.dto.RestaurantDto;
import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.exception.ResourceNotFoundException;
import com.substring.foodie.substring_foodie.repository.RestaurantRepository;
import com.substring.foodie.substring_foodie.service.FileService;
import com.substring.foodie.substring_foodie.service.RestaurantService;
import com.substring.foodie.substring_foodie.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Value("${restaurant.file.path}")
    private String bannerFolderPath;
    private RestaurantRepository restaurantRepository;
    private ModelMapper modelMapper;
    private FileService fileService;
    private RestaurantServiceImpl(RestaurantRepository restaurantRepository, ModelMapper modelMapper, FileService fileService) {
        this.restaurantRepository = restaurantRepository;
        this.modelMapper = modelMapper;
        this.fileService = fileService;
    }

    @Override
    public RestaurantDto add(RestaurantDto restaurantDto) {
        restaurantDto.setId(Helper.generateRandomId());
        restaurantDto.setCreatedDateAndTime(LocalDateTime.now());
        // convert dto to entity here to pass this in entity class here
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return modelMapper.map(savedRestaurant,RestaurantDto.class);
    }

    @Override
    public RestaurantDto update(RestaurantDto restaurantDto, String id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant Not Found!!!"));
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setDescription(restaurantDto.getDescription());
        restaurant.setCloseTime(restaurantDto.getCloseTime());
        restaurant.setOpenTime(restaurantDto.getOpenTime());
        restaurant.setIsOpen(restaurantDto.getIsOpen());
        Restaurant savedEntity = restaurantRepository.save(restaurant);
        return modelMapper.map(savedEntity,RestaurantDto.class);
    }

    @Override
    public void delete(String id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant Not Found!!!"));
        restaurantRepository.delete(restaurant);
    }

    @Override
    public RestaurantDto getById(String id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant Not Found!!!"));
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    @Override
    public Page<RestaurantDto> getAll(Pageable pageable) {
        Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageable);
        return restaurantPage.map(restaurant -> modelMapper.map(restaurant,RestaurantDto.class));
    }

    @Override
    public List<RestaurantDto> searchByName(String keyword) {
        return restaurantRepository.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(restaurant -> modelMapper.map(restaurant,RestaurantDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<RestaurantDto> getOpenRestaurant(Pageable pageable) {
        Page<Restaurant> restaurantPage = restaurantRepository.findByIsOpen(true,pageable);
        return restaurantPage.map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class));
    }

    @Override
    public List<RestaurantDto> getOpenRestaurantAtGivenTime(LocalTime time) {
        List<Restaurant> restaurants = restaurantRepository.findByIsOpenAndTimeBetweenOpenTimeAndCloseTime(true, time);
        return restaurants
                .stream()
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto uploadBanner(MultipartFile file, String id) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileExtenstion = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = new Date().getTime() + fileExtenstion;
        FileData fileData = fileService.uploadFile(file, bannerFolderPath + newFileName);
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant doesn't exists."));
        restaurant.setBanner(fileData.getFileName());
        restaurantRepository.save(restaurant);
        return modelMapper.map(restaurant,RestaurantDto.class);
    }
}
