/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.aspect;

import com.samirhasanov.spring.aop.domain.User;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author Hasanov (Asus)
 */
public class PointcutContainer {
    
    @Pointcut("execution(* com.samirhasanov.spring.aop.dao.UserDao.save(..))")
    public void executionUserDaoSave() {}
    
    @Pointcut("execution(* com.samirhasanov.spring.aop.dao.UserDao.getItem(..))")
    public void executionUserDaoGetItem() {}
    
    @Pointcut("execution(* com.samirhasanov.spring.aop.service.UserService.save(..)) && args(user)")
    public void executionUserServiceSave(User user) {}
}
