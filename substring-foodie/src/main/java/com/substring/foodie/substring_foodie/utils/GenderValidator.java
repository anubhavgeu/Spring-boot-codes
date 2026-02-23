package com.substring.foodie.substring_foodie.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenderValidator implements ConstraintValidator<ValidGender,String> {
    private Logger logger = LoggerFactory.getLogger(GenderValidator.class);
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            logger.warn("Invalid gender string");
            return false;
        }
        return s.equalsIgnoreCase("male") || s.equalsIgnoreCase("female");
    }
}
