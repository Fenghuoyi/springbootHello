package com.sun.springboothello.threadTest4;

public class TestDemo {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread2 myThread2 = new MyThread2();

        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);

        thread1.setName("女神");
        thread2.setName("备胎");

        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

    }
}
