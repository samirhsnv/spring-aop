/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author Hasanov (Asus)
 */
@Configuration
@ComponentScan(basePackages = "com.samirhasanov.spring.aop")
@EnableAspectJAutoProxy
public class AppConfig {
    // * We will use JDK proxy classes for AOP (by default. JDK proxying is interface-based proxying)
    //
    // * If you want to use CGLIB proxy classes 
    //     (subclass-based proxying) then you should use @EnableAspectJAutoProxy(proxyTargetClass = true)
}
