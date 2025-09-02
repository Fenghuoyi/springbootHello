package com.sun.springboothello.java.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadFactory;

@Component
public class ThreadPoolExecutorFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("haha");
        return thread;
    }
}
