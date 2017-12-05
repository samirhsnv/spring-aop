/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.service;

import com.samirhasanov.spring.aop.domain.User;
import com.samirhasanov.spring.aop.exception.CustomException;
import com.samirhasanov.spring.aop.exception.NotFoundException;
import java.util.List;

/**
 *
 * @author Hasanov (Asus)
 */
public interface IUserService {
    public void save(User user);

    public List<User> getAll();

    public User getItem(Long id) throws CustomException;

    public void remove(User item) throws NotFoundException;
}
