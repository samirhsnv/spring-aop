/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.exception;

/**
 *
 * @author Hasanov (Asus)
 */
public class ValidationException extends CustomException {
    public ValidationException(String message) {
        super(message);
    }
}
