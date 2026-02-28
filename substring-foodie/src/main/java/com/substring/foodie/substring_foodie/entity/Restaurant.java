package com.substring.foodie.substring_foodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "foodie_restaurant")
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    private String id;
    @Lob
    private String description;
    private String name;
    private String address;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Boolean isOpen = true;
    @JsonIgnore
    private String banner;
    private LocalDateTime createdDateAndTime;
    @JsonProperty
    public String imageUrl() {
        return "http://localhost:8080/images/"+banner;
    }
    @ManyToOne
    private User user;

}
