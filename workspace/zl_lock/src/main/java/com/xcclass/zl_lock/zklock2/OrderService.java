package com.xcclass.zl_lock.zklock2;

import com.xcclass.zl_lock.zklock1.ExtLock;
import com.xcclass.zl_lock.zklock1.OrderNumGenerator;
import com.xcclass.zl_lock.zklock1.ZookeeperDistrbuteLock;

public class OrderService implements Runnable{
    private ExtLock extLock=new ZookeeperDistrbuteLock();
    private OrderNumGenerator orderNumGenerator=new OrderNumGenerator();
    @Override

    public void run() {
        createOrderNum();
    }
    @SuppressWarnings("all")
    public void createOrderNum(){
        try {
            extLock.getLock();
           String number = orderNumGenerator.getNumber();
            System.out.println("线程："+Thread.currentThread().getName()+",生成订单id"+number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            extLock.unLock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new OrderService()).start();
        }
    }
}
