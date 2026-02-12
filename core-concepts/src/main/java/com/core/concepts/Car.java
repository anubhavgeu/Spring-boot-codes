package com.core.concepts;

import org.springframework.stereotype.Component;

@Component
public class Car {
    //manually created...
    Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        // first bring engine;
        engine.startEngine();
        System.out.println("Car started...");
    }
}
