package com.substring.foodie.controller.example;


import com.substring.foodie.playload.example.UserDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    public void login() {

    }
    @RequestMapping("/signup")
    public String signup(@Valid @RequestBody UserDTO userDTO) {
        logger.info("User name: {}", userDTO.getName());
        logger.info("User password :{}", userDTO.getPassword());
        logger.info("User email: {}", userDTO.getEmail());
        logger.info("User age: {}", userDTO.getAge());
        return "success";
    }

    // exception handling method
    // null pointer exception
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        String message = ex.getMessage();
//        logger.error(message);
//        return ex.getMessage();
//    }
}
