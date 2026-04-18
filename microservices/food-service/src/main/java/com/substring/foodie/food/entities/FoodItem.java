package com.substring.foodie.food.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food_service_food_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {
    @Id
    private String id;
    private String title;
    private String description;
    private int quantity;
    private boolean outOfStock = true;
    @Enumerated(EnumType.STRING)
    private FoodType foodType = FoodType.VEG;
    @ManyToOne
    private FoodCategory foodCategory;

    // store the restaurant info
    @Column(nullable = false)
    private String restaurantId;
}
