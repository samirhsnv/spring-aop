/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.main;

import com.samirhasanov.spring.aop.config.AppConfig;
import com.samirhasanov.spring.aop.domain.User;
import com.samirhasanov.spring.aop.exception.CustomException;
import com.samirhasanov.spring.aop.service.IUserService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Hasanov (Asus)
 */
public class Main {
    public static void main(String[] args) throws CustomException {
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IUserService userService = applicationContext.getBean(IUserService.class);
        
        List<User> users = userService.getAll();
        System.out.println(users);
        
        userService.save(new User("Rokki Balboa", 50));
        
        users = userService.getAll();
        System.out.println(users);
        
        User user = userService.getItem(3L);
        System.out.println("User: " + user);
    }
}
