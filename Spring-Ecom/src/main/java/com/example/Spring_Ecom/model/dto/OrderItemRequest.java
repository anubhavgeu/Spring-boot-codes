package com.example.Spring_Ecom.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {}
