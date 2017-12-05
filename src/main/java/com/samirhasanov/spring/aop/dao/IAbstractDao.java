/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.dao;

import com.samirhasanov.spring.aop.exception.CustomException;
import com.samirhasanov.spring.aop.exception.NotFoundException;
import java.util.List;

/**
 *
 * @author Hasanov (Asus)
 */
public interface IAbstractDao<T> {

    public void save(T item);

    public List<T> getAll();

    public T getItem(Long id) throws CustomException;

    public void remove(T item) throws NotFoundException;
}
