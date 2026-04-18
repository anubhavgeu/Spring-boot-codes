package com.substring.foodie.restaurant.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String address;
    private String phone;
    @ElementCollection
    private List<String> pictures = new ArrayList<>();
    // priority 1 -> if open = true -> then check for time
    private boolean open = false;
    private LocalTime openTime;
    private LocalTime closeTime;
    @Lob
    private String aboutRestaurant;
}
