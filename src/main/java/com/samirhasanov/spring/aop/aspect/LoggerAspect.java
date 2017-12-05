/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.aspect;

import com.samirhasanov.spring.aop.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hasanov (Asus)
 */
@Aspect
@Component
public class LoggerAspect {
    
    @Before("com.samirhasanov.spring.aop.aspect.PointcutContainer.executionUserDaoSave()")
    public void beforeSave(JoinPoint joinPoint) {
        System.out.println("@Before Calling dao save method");
        System.out.println("--- params ---");
        
        Object[] args = joinPoint.getArgs();
        
        for(Object o: args) {
            System.out.println(o);
        }
        
        System.out.println(" *** ");
    }
    
    @AfterThrowing(pointcut = "com.samirhasanov.spring.aop.aspect.PointcutContainer.executionUserDaoGetItem()", throwing = "e")
    public void onNotFoundException(JoinPoint joinPoint, Exception e) {
        System.out.println(String.format("@AfterThrowing Method %s threw exception, Exception is: %s", joinPoint.getSignature().getName(), e.getClass().getName()));
        System.out.println(" *** ");
    }
    
    @AfterReturning(pointcut = "com.samirhasanov.spring.aop.aspect.PointcutContainer.executionUserDaoGetItem()", returning = "user")
    public void onGetItemReturn(JoinPoint joinPoint, User user) {
        System.out.println("@AfterReturning Method called: " + joinPoint.getSignature().getName() + ", object returned: " + user);
        Object[] args = joinPoint.getArgs();
        
        System.out.println("--- params passed ---");
        for(Object o: args) {
            System.out.println(o);
        }
        
        System.out.println(" *** ");
    }
    
    @After("com.samirhasanov.spring.aop.aspect.PointcutContainer.executionUserDaoGetItem()")
    public void getItemTimeMeasuring(JoinPoint joinPoint) {
        System.out.println("@After method called: " + joinPoint.getSignature().getName());
        System.out.println(" *** ");
    }
    
    @Around("com.samirhasanov.spring.aop.aspect.PointcutContainer.executionUserDaoGetItem()")
    public Object getItemTimeMeasurement(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long time1 = System.currentTimeMillis();
        
        try {
            Thread.sleep(1L);
            return proceedingJoinPoint.proceed();
        }
        finally {
            long proceedingTime = System.currentTimeMillis() - time1;
            System.out.println("@Around getItem method call. Time: " + proceedingTime);
            System.out.println(" *** ");
        }
    }
}
