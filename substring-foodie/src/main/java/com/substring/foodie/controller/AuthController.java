package com.substring.foodie.controller;


import com.substring.foodie.dto.JwtResponse;
import com.substring.foodie.dto.LoginRequest;
import com.substring.foodie.dto.RefreshTokenRequest;
import com.substring.foodie.dto.UserDto;
import com.substring.foodie.entity.User;
import com.substring.foodie.repository.UserRepo;
import com.substring.foodie.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private UserRepo userRepo;
    private ModelMapper modelMapper;

    public AuthController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtService jwtService, UserRepo userRepo, ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        authenticationManager.authenticate(authenticationToken);
        String jwtToken = jwtService.generateToken(loginRequest.email(),true);
        String refreshToken = jwtService.generateToken(loginRequest.email(),false);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.email());
        UserDto user = modelMapper.map(userRepo.findByEmail(userDetails.getUsername()).get(), UserDto.class);
        JwtResponse build = JwtResponse
                .builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .userDto(user)
                .build();
        return ResponseEntity.ok(build);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(
            @RequestBody RefreshTokenRequest refreshTokenRequest
    ) {
        if (jwtService.validateToken(refreshTokenRequest.getRefreshToken()) && jwtService.isRefreshToken(refreshTokenRequest.getRefreshToken())) {
            String usernameFromRefreshToken = jwtService.getUsername(refreshTokenRequest.getRefreshToken());
            UserDto userDto = modelMapper.map(userRepo.findByEmail(usernameFromRefreshToken), UserDto.class);
            String accessToken = jwtService.generateToken(userDto.getEmail(), true);
            String refreshToken = jwtService.generateToken(refreshTokenRequest.getRefreshToken(), false);
            JwtResponse response = JwtResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .userDto(userDto)
                    .build();
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid refresh token!!!");
        }
    }
}

