package com.sun.springboothello.java.test;

public class BigStar implements Star{

    private String name;

    public String sing(String name){
        System.out.println(this.name+"正在唱一首"+name);
        return "谢谢";
    }

    public String dance(String name){
        System.out.println(this.name+"正在跳舞");
        return "谢谢";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigStar(String name) {
        this.name = name;
    }
}
