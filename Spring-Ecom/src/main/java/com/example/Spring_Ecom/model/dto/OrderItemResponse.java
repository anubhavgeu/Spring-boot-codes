package com.example.Spring_Ecom.model.dto;

import java.math.BigDecimal;

public record OrderItemResponse(
        String productName,
        int quantity,
        BigDecimal totalPrice
) { }
