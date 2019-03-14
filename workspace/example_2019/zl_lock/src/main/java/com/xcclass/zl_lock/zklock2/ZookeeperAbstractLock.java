package com.xcclass.zl_lock.zklock2;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

public abstract  class ZookeeperAbstractLock  implements ExtLock{
    private String CONNECTION="127.0.0.1:2181";
    protected ZkClient zkClient=new ZkClient(CONNECTION);
    protected String LOCK_PATH="/path";
    protected CountDownLatch countDownLatch;
    @Override
    public void getLock() {
        if(tryLock()){

        }else{
            waitFor();
            getLock();
        }
    }

    @Override
    public void unLock() {

    }
    abstract boolean tryLock();
    abstract void waitFor();
}
