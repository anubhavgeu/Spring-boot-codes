package com.substring.foodie.substring_foodie.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);
    }
    public ResourceNotFoundException() {
        super("Resource not found");
    }
}
