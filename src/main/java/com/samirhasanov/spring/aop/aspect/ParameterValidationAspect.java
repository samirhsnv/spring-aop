/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.aspect;

import com.samirhasanov.spring.aop.domain.User;
import com.samirhasanov.spring.aop.exception.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hasanov (Asus)
 */
@Aspect
@Component
public class ParameterValidationAspect {
    
    @Before("com.samirhasanov.spring.aop.aspect.PointcutContainer.executionUserServiceSave(user)")
    public void validateSaveMethod(JoinPoint joinPoint, User user) throws ValidationException {
        System.out.println("Called @Before UserService.save(..) method");
        
        Object[] args = joinPoint.getArgs();
        
        for(Object o: args) {
            System.out.println("Param: " + o);
        }
        
        if(user == null || user.getAge() > 50) {
            throw new ValidationException("Invalid user parameter. User: " + user);
        }
        
        System.out.println(" *** ");
    }
}
