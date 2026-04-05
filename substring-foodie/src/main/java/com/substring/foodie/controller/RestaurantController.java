package com.substring.foodie.controller;

import com.substring.foodie.dto.RestaurantDto;
import com.substring.foodie.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.addRestaurant(restaurantDto));
    }

    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable String restaurantId, @RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.updateRestaurant(restaurantDto, restaurantId));
    }

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<Page<RestaurantDto>> getAllRestaurant(
            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "desc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, size, sort);
        return ResponseEntity.ok(restaurantService.getRestaurants(pageable));
    }


    @GetMapping("/getByName/{keyword}")
    public ResponseEntity<List<RestaurantDto>> getRestaurantByName(@PathVariable String keyword) {
        return ResponseEntity.ok(restaurantService.searchByName(keyword));
    }

    @GetMapping("/getOpenRestaurant")
    public ResponseEntity<Page<RestaurantDto>> getOpenRestaurant(
            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(value = "sortDir", required = false, defaultValue = "asc") String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, size, sort);
        return ResponseEntity.ok(restaurantService.getOpenRestaurants(pageable));
    }

    @GetMapping("/getRestaurantById/{restaurantId}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable String restaurantId) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(restaurantId));
    }

}
