package com.substring.foodie.restaurant.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
