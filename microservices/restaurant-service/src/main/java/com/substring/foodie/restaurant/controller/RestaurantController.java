package com.substring.foodie.restaurant.controller;

import com.substring.foodie.restaurant.dto.RestaurantDto;
import com.substring.foodie.restaurant.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto saveRestaurant = restaurantService.save(restaurantDto);
        return new ResponseEntity<>(saveRestaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> update(@PathVariable String id, @RequestBody RestaurantDto restaurantDto) {
        RestaurantDto updateRestaurant = restaurantService.update(id, restaurantDto);
        return new ResponseEntity<>(updateRestaurant, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> findById(@PathVariable String id) {
        RestaurantDto restaurantDto = restaurantService.getById(id);
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RestaurantDto> findByName(@PathVariable String name) {
        RestaurantDto restaurantDto = restaurantService.findByName(name);
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        restaurantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> findAll() {
        List<RestaurantDto> restaurantDtos = restaurantService.getAll();
        return new ResponseEntity<>(restaurantDtos, HttpStatus.OK);
    }
}
