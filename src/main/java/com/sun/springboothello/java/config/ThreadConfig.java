package com.sun.springboothello.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class ThreadConfig {

    private int corePoolSize = 5; // 核心线程数
    private int maximumPoolSize = 10; // 最大线程数
    private long keepAliveTime = 60L; // 空闲线程的存活时间（单位：秒）
    TimeUnit unit = TimeUnit.SECONDS; // 存活时间的单位

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        BlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>(1000);
        ThreadFactory threadFactory = new ThreadPoolExecutorFactoryBean();
        RejectedExecutionHandler handler = new ThreadPoolExecutorHandle();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                workQueue,
                threadFactory,
                handler
        );
        return threadPoolExecutor;
    }
}
