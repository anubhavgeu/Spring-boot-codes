package com.substring.foodie.substring_foodie.repository;

import com.substring.foodie.substring_foodie.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalTime;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    List<Restaurant> findByNameContainingIgnoreCase(String name);
    Page<Restaurant> findByIsOpen(boolean flag, Pageable pageable);
    // TODO: get restaurant based on open timings;
    @Query("SELECT r FROM Restaurant r WHERE r.isOpen = :flag AND :time >= r.openTime AND :time <= r.closeTime")
    List<Restaurant> findByIsOpenAndTimeBetweenOpenTimeAndCloseTime(@Param(value = "flag") boolean flag, @Param(value = "time") LocalTime time);
}
