package com.substring.foodie.playload.example;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "Name should not be empty or blank")
    @Size(min = 3, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;
    @Max(value = 140, message = "Enter age <= 140")
    @Min(value = 18, message = "Enter age >= 18")
    private int age;
    @NotBlank(message = "Email should not be empty or blank")
    @Email(message = "Enter valid email")
    private String email;
    @NotBlank(message = "Password should not be empty or blank")
    private String password;
}
