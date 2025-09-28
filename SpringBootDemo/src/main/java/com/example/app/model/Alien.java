package com.example.app.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    public Computer getCom() {
        return com;
    }

    @Autowired
    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Value("25")
    private int age;

    @Autowired
    private Computer com;

    @Autowired
    CPU gpu;
    public void code() {
        System.out.println("I'm a programmer.");
        com.compile();
        gpu.gpuUsed();
    }
}
