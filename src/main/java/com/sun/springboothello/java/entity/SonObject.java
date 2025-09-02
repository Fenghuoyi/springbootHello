package com.sun.springboothello.java.entity;

public class SonObject extends BaseObject{
    public SonObject(String gender) {
        super(gender);
    }

    public String name;

    public SonObject(String gender, String name) {
        super(gender);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SonObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
