package com.substring.foodie.substring_foodie.repository;

import com.substring.foodie.substring_foodie.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    List<Restaurant> findByNameContainingIgnoreCase(String name);
    Page<Restaurant> findByIsOpen(boolean flag, Pageable pageable);
    // TODO: get restaurant based on open timings;
}
