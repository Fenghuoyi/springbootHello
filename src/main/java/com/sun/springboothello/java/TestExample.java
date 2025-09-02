package com.sun.springboothello.java;

import com.sun.springboothello.java.test.BigStar;
import com.sun.springboothello.java.test.Star;
import com.sun.springboothello.java.util.ProxyUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestExample {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        /*BigStar bigStar = new BigStar("鸡哥");
        Star proxy = ProxyUtil.getProxy(bigStar);

        String result = proxy.sing("只因你太美");
        System.out.println(result);

        String result1 = proxy.dance("只因你太美");
        System.out.println(result);*/

        /*Class clazz = Class.forName("com.sun.springboothello.java.entity.SonObject");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }*/

        Class clazz = Class.forName("com.sun.springboothello.java.test.Student");
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();


        Method method = clazz.getDeclaredMethod("study");
        method.setAccessible(true);
        method.invoke(o);


    }
}
