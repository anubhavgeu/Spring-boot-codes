package com.substring.foodie.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "foodie_restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String address;
    private LocalTime localTime;
    private LocalTime closeTime;
    private boolean isOpen = true;
    @ManyToOne
    private User user;
}
