package com.substring.foodie.substring_foodie.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Data
@Getter
@Setter
@Builder
public class ErrorResponse {
    private String message;
    private HttpStatus status;
}
