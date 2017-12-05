/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.service;

import com.samirhasanov.spring.aop.dao.IUserDao;
import com.samirhasanov.spring.aop.domain.User;
import com.samirhasanov.spring.aop.exception.CustomException;
import com.samirhasanov.spring.aop.exception.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hasanov (Asus)
 */
@Service
public class UserService implements IUserService {
    private final IUserDao iUserDao;
    
    @Autowired
    public UserService(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }
    
    @Override
    public void save(User user) {
        this.iUserDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return this.iUserDao.getAll();
    }

    @Override
    public User getItem(Long id) throws CustomException {
        return this.iUserDao.getItem(id);
    }

    @Override
    public void remove(User item) throws NotFoundException {
        this.iUserDao.remove(item);
    }
    
}
