package com.substring.foodie.exception;


import com.substring.foodie.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        String message = ex.getMessage();
//        logger.error(message);
//        return ex.getMessage();

        Map<String, String> errorMap = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        allErrors.forEach(error -> {
            // field of the error; -> fetch the field first;
            String fieldName = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            errorMap.put(fieldName, defaultMessage);
        });
        return errorMap;
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse msgOb = ErrorResponse.builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NO_CONTENT)
                .build();
        return new ResponseEntity<>(msgOb, HttpStatus.NOT_FOUND);
    }
}
