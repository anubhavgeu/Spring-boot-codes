package com.substring.foodie.substring_foodie.repository;

import com.substring.foodie.substring_foodie.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
}
