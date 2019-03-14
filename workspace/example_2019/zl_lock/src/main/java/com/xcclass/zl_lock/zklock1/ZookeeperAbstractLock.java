package com.xcclass.zl_lock.zklock1;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

public abstract class ZookeeperAbstractLock implements ExtLock {
    private String CONNECTION="127.0.0.1:2181";
    protected ZkClient zkClient=new ZkClient(CONNECTION);
    protected String LOCK_PATH="/path";
    protected CountDownLatch countDownLatch;
    @Override
    public void getLock() {
        //1.尝试的获取锁
        //###1.1获取成功
        //###1.2获取失败
        //#####1.2.1 线程等待并且监听节点
        //#####1.2.2 若节点删除（释放锁）唤醒线程 重新尝试获取锁
        if(tryLock()){
            System.out.println("####获取锁成功####");
        }else {
            waitFor();
            getLock();
        }

    }
    @Override
    public void unLock() {
        if(zkClient!=null){
            zkClient.close();
            System.out.println("####释放锁成功####");
        }
    }
    abstract boolean tryLock();
    abstract  void waitFor();
}
