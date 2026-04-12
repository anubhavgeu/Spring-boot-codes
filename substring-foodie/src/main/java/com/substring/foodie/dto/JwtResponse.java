package com.substring.foodie.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Builder
public class JwtResponse {
    private String token;
    private UserDto userDto;
}
