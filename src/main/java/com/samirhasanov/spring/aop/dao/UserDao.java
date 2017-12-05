/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.dao;

import com.samirhasanov.spring.aop.domain.User;
import com.samirhasanov.spring.aop.exception.CustomException;
import com.samirhasanov.spring.aop.exception.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hasanov (Asus)
 */
@Repository
public class UserDao implements IUserDao {
    private final Map<Long, User> users = new HashMap<>();
    
    @PostConstruct
    private void init() {
        users.put(1L, new User(1L, "Samir Hasanov", 28));
        users.put(2L, new User(2L, "Murad Rzayev", 27));
    }
    
    @Override
    public void save(User item) {
        if(item.getId() == null) {
            item.setId((long) users.size() + 1);
        }
        
        users.put(item.getId(), item);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getItem(Long id) throws CustomException {
        User user = users.get(id);
        
        if(user == null) {
            if(id > 10L) {
                throw new CustomException("User not found. CUstom exception.");
            }
            
            throw new NotFoundException("User not found. Id: " + id);
        }
        
        return user;
    }

    @Override
    public void remove(User item) throws NotFoundException {
        User user = users.get(item.getId());
        
        if(user == null) {
            throw new NotFoundException("Cannot remove user. Id does not exist: " + item.getId());
        }
        
        users.remove(item.getId());
    }
    
}
