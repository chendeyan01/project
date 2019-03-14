package com.xcclass.zl_lock.zklock1;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

public class ZookeeperDistrbuteLock extends  ZookeeperAbstractLock{
    @Override
    boolean tryLock() {
        try {
            //创建临时节点成功
            zkClient.createEphemeral(LOCK_PATH);
            return true;
        } catch (RuntimeException e) {
            //创建临时节点失败
            return false;
        }
    }

    @Override
    void waitFor() {

        IZkDataListener iZkDataListener = new IZkDataListener(){
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if(countDownLatch!=null){
                    countDownLatch.countDown();
                }
            }
        };
        //添加监听事件
        zkClient.subscribeDataChanges(LOCK_PATH,iZkDataListener);
        //判断临时节点是否存在 为什么去判断? 在此刻持有锁的线程有可能已经释放锁了
        //当前线程持有锁的话
        if(zkClient.exists(LOCK_PATH)){
            countDownLatch=new CountDownLatch(1);
            try {
                //挂起线程
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
