package com.substring.foodie.substring_foodie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto {
    private String id;
    @Lob
    private String description;
    private String name;
    private String address;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Boolean isOpen = true;
    private String banner;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss a"
    )
    private LocalDateTime createdDateAndTime;
}
