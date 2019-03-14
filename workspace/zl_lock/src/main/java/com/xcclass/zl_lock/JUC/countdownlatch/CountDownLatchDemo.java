package com.xcclass.zl_lock.JUC.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo extends Thread{
    private static CountDownLatch countDownLatch=new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new CountDownLatchDemo().start();
        }

        countDownLatch.await();
        System.out.println("3个线程执行完毕");
        System.out.println("主线程执行完毕");
    }

    @Override
    public void run() {
        countDownLatch.countDown();

    }
}
