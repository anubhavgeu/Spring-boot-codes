package com.substring.foodie.substring_foodie.config;

public class AppConstants {
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    public static String getRoleAdmin() {
        return "ROLE_" + ROLE_ADMIN;
    }
    public static String getRoleUser() {
        return "ROLE_" + ROLE_USER;
    }
}
