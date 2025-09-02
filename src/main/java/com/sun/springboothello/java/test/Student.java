package com.sun.springboothello.java.test;

public class Student {

    private String name;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void study(){
        System.out.println("学生正在学习");
    }
}
