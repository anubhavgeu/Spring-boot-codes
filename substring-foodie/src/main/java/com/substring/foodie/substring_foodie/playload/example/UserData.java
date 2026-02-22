package com.substring.foodie.substring_foodie.playload.example;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserData {
    @NotEmpty(message = "Name is required")
    @Size(min = 3, max = 20, message = "Put valid username length")
    private String name;
    @Max(value = 99, message = "Invalid Age!!")
    @Min(value = 18, message = "Min value required is 18.")
    private int age;
    @Email(message = "Invalid email!!")
    private String email;
    @NotEmpty(message = "Password is required")
    private String password;
}
