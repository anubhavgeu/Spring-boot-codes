package com.core.concepts;

import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {
    public void startEngine() {
        System.out.println("Engine started...");
    }
}
