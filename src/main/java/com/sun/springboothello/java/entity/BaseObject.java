package com.sun.springboothello.java.entity;

public class BaseObject {

    public String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BaseObject(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "BaseObject{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
