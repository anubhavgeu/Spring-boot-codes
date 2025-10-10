package com.example.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ValidationAspect.class);


    @Around("execution(* com.example.spring_boot_rest.service.JobService.*(..)) && args(postId)")
    public Object validationAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
        Object obj;

        if (postId < 0) {
            LOGGER.info("Post id is negative, making it positive");
            postId = -postId;
        }
        obj = jp.proceed(new Object[]{postId});
        return obj;
    }
}
