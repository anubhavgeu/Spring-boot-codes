package com.first.first_boot_project.aop;
@Aspect
public class LoggingAspect {
    public void greeting() {
        System.out.println("Method started.......");
    }
}
