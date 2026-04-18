package com.substring.foodie.food.dto;

import jakarta.persistence.ElementCollection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RestaurantDto {
    private String id;
    private String name;
    private String address;
    private String phone;
    @ElementCollection
    private List<String> pictures = new ArrayList<>();
    private boolean open = false;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String aboutRestaurant;
}
