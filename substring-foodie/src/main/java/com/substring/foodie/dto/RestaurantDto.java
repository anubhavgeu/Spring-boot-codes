package com.substring.foodie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto {
    private String id;
    private String name;
    private String description;
    private String address;
    @JsonFormat(
            shape =  JsonFormat.Shape.STRING,
            pattern = "hh:mm:ss a"
    )
    private LocalTime openTime;
    @JsonFormat(
            shape =  JsonFormat.Shape.STRING,
            pattern = "hh:mm:ss a"
    )
    private LocalTime closeTime;
    private String banner;
    @JsonFormat(
            shape =  JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy"
    )
    private LocalDate createdAt;
    private boolean isOpen = true;
}
