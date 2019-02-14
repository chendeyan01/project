package com.xcclass.zl_lock.JUC.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Cyclicbarrierdemo extends Thread{
    private CyclicBarrier cyclicBarrier;
   public   Cyclicbarrierdemo(CyclicBarrier cyclicBarrier){
       this.cyclicBarrier=cyclicBarrier;
   }
    public static void main(String[] args) {
         CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
        for (int i = 0; i <6; i++) {
            new Cyclicbarrierdemo(cyclicBarrier).start();
        }
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            System.out.println("执行成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
