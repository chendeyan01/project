package com.xcclass.zl_lock.JUC.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo extends  Thread {
    private Semaphore semaphore;
    public SemaphoreDemo(Semaphore semaphore){
        this.semaphore=semaphore;
    }
    @Override
    public void run() {
        int availablePermits = semaphore.availablePermits();
        if(availablePermits>0){
            System.out.println("有资源");
        }else{
            System.out.println("没有资源");
        }

        try {
            //申请资源
            semaphore.acquire();
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        System.out.println("资源释放");
    }

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for(int i=0;i<10;i++){
            SemaphoreDemo semaphoreDemo = new SemaphoreDemo(semaphore);
            semaphoreDemo.start();
        }
    }
}
