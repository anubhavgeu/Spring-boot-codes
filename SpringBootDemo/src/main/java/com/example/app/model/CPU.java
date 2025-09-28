package com.example.app.model;

import org.springframework.stereotype.Component;

@Component
public class CPU {
    public void gpuUsed() {
        System.out.println("The GPU used is of NVIDIA");
    }
}
