package com.example.seproject2022.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoggingAspect {

        private static final AopUtilities aopUtilities = new AopUtilities();

        private static final String FILENAME = "logs.txt";

        @Before("execution(* com.example.seproject2022.controller.*.*(..))")
        public void beforeControllerAdvice(JoinPoint joinPoint) {
                Object[] args = joinPoint.getArgs();
                HttpServletRequest request = (HttpServletRequest) args[args.length - 1];
                String loggingMessage = LocalDateTime.now(ZoneId.of("UTC+2")) + " : localhost:8080"
                        + request.getRequestURI();
                aopUtilities.writeToFile(FILENAME, loggingMessage);
        }

        @Before("execution(* com.example.seproject2022.service.impl.*.*(..))")
        public void beforeServiceAdvice(JoinPoint joinPoint) {
                MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
                String loggingMessage = LocalDateTime.now(ZoneId.of("UTC+2")) + " : " + methodSignature.toShortString();
                aopUtilities.writeToFile(FILENAME, loggingMessage);
        }

        @Before("execution(* com.example.seproject2022.repository.*.*(..))")
        public void beforeRepositoryAdvice(JoinPoint joinPoint) {
                MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
                String loggingMessage = LocalDateTime.now(ZoneId.of("UTC+2")) + " : " + methodSignature.toShortString();
                aopUtilities.writeToFile(FILENAME, loggingMessage);
        }
}
