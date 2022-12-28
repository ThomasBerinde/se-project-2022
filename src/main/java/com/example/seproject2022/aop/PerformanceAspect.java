package com.example.seproject2022.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Aspect
@Component
public class PerformanceAspect {

        private static final AopUtilities aopUtilities = new AopUtilities();
        private static final String FILENAME = "performance.txt";
        private long startTime;

        @Before("execution(* com.example.seproject2022.service.impl.*.*(..))")
        public void beforeServiceAdvice(JoinPoint joinPoint) {
                startTime = System.nanoTime();
        }

        @After("execution(* com.example.seproject2022.service.impl.*.*(..))")
        public void afterServiceAdvice(JoinPoint joinPoint) {
                MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
                long elapsedTime = System.nanoTime() - startTime;
                String performanceLoggingMessage = LocalDateTime.now(ZoneId.of("UTC+2")) + " : "
                        + methodSignature.toShortString() + "   " + elapsedTime + "ns";
                aopUtilities.writeToFile(FILENAME, performanceLoggingMessage);
        }
}
