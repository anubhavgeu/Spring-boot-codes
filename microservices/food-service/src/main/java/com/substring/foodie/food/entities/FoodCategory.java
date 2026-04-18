package com.substring.foodie.food.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food_service_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategory {
    @Id
    private String id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> foodItemList = new ArrayList<>();
}
