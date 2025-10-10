package com.example.spring_boot_rest.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.example.spring_boot_rest.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time taken: " + jp.getSignature().getName() +" is " + (end-start) + " ms.");
        return obj;
    }
}
