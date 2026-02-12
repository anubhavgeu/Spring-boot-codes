package com.core.concepts.beanLifeCycle;

import org.springframework.stereotype.Component;

@Component
public class Motor {
    public void thisIsEngine() {
        System.out.println("This is engine class");
    }
}
