package com.substring.foodie.substring_foodie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "foodie_restaurant")
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String address;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Boolean isOpen = true;

    @ManyToOne
    private User user;

}
