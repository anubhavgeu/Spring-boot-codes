package com.substring.foodie.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    @Lob
    private String description;
    private String address;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String banner;
    private boolean isOpen = true;
    private LocalDate createdAt;
    @ManyToOne
    private User user;
}
