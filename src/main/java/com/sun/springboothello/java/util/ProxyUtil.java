package com.sun.springboothello.java.util;

import com.sun.springboothello.java.test.BigStar;
import com.sun.springboothello.java.test.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Star getProxy(BigStar bigStar){
        Star proxy = (Star)Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if("sing".equals(method.getName())){
                            System.out.println("准备歌曲，收钱");
                        }
                        if("dance".equals(method.getName())){
                            System.out.println("准备舞台，收钱");
                        }

                        return method.invoke(bigStar,args);
                    }
                }
        );
        return proxy;
    }

}
