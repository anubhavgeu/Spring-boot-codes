package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;



@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoggingAspect.class);


    // return type, class Name(including the package), method Name, args
    // Use * to work on all the methods;
    // work only for method updateJob;
    @Before("execution(* com.example.spring_boot_rest.service.JobService.updateJob(..)) || ")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }


    @After("execution(* com.example.spring_boot_rest.service.JobService.updateJob(..)) || ")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

}
