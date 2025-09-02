package com.sun.springboothello.threadTest3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程类
        MyThread myThread = new MyThread();

        // 创建管理对象类
        FutureTask<Integer> futureTask = new FutureTask(myThread);

        Thread thread = new Thread(futureTask);

        thread.start();

        Integer sum = futureTask.get();

        System.out.println(sum);
    }
}
