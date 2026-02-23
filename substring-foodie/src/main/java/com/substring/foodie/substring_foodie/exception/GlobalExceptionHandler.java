package com.substring.foodie.substring_foodie.exception;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException nullPointerException) {
        logger.error(nullPointerException.getMessage());
        nullPointerException.printStackTrace();
        return nullPointerException.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errorMap = new HashMap<>();
        // fetch all errors list from binding result
        List<ObjectError> allErrors = methodArgumentNotValidException.getBindingResult().getAllErrors();

        // iterate all error and put it in the map;
        allErrors.forEach(error -> {
            // fetch the field name first;
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            errorMap.put(field,defaultMessage);
        });
        return errorMap;
    }
}
