package com.substring.foodie.repository;

import com.substring.foodie.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant, String> {
    List<Restaurant> findByNameContainingIgnoreCase(String keyword);
    Page<Restaurant> findByIsOpen(boolean flag, Pageable pageable);
    // get restaurant based on time;
}
