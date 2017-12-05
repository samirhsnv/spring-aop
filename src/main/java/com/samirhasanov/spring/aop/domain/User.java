/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.aop.domain;

/**
 *
 * @author Hasanov (Asus)
 */
public class User {
    private Long id;
    private String fullname;
    private Integer age;

    public User() {
    }

    public User(Long id, String fullname, Integer age) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
    }

    public User(String fullname, Integer age) {
        this.fullname = fullname;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullname=" + fullname + ", age=" + age + '}';
    }
}
