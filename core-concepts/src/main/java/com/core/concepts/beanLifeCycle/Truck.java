package com.core.concepts.beanLifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Truck implements InitializingBean, DisposableBean {
    Motor engine;

    public Truck(Motor engine) {
        this.engine = engine;
        System.out.println("Constructor injection");
    }

    public Truck() {
        System.out.println("Truck is instantiated");
    }

    public Motor getEngine() {
        return this.engine;
    }

    @Autowired
    public void setEngine(Motor engine) {
        this.engine = engine;
        System.out.println("Setter injection");
    }

    public void run() {
        System.out.println("Inside run method of Truck and then calling engine method");
        engine.thisIsEngine();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("We are in after property set");
        System.out.println(engine);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Just before destroying Truck bean");
    }
}
