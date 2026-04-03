package com.substring.foodie.playload.example;


import com.substring.foodie.utils.ValidGender;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "Name should not be empty or blank")
    @Size(min = 3, max = 20, message = "Name must be between 2 and 20 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+(?: [A-Za-z\\d@$!%*?&]+)*$", message = "Invalid username, Username must contain 1 capital letter, 1 digit and 1 special character")
    private String name;
    @Max(value = 140, message = "Enter age <= 140")
    @Min(value = 18, message = "Enter age >= 18")
    private int age;
    @NotBlank(message = "Email should not be empty or blank")
    @Email(message = "Enter valid email")
    private String email;
    @ValidGender
    private String gender;
    @NotBlank(message = "Password should not be empty or blank")
    private String password;
}
