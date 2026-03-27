/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptproject.asm_gd1.entity;

import java.util.Set; 
/**
 *
 * @author Admin
 */
public class Student {

    private String id;
    private String name;
    private int age;
    private String email;
    private double mark;

    public Student() {
    }

    public Student(String id, String name, int age, String email, double mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "{\nid: "+ this.id + ",\nname: " 
                + this.name + ",\nage: " 
                + this.age + ",\nemail: " 
                + this.email + ",\nmark: "    
                + this.mark + "\n}";
    }

    
    
}
