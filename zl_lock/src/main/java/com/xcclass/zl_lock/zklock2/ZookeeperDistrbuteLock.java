package com.xcclass.zl_lock.zklock2;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {
    private String currentPath;
    private  String beforePath;
    public ZookeeperDistrbuteLock(){
        if(!zkClient.exists(LOCK_PATH)){
            zkClient.createPersistent(LOCK_PATH);
        }
    }
    @Override
    boolean tryLock() {
        //判断每个线程的临时顺序节点
        //不存在创建临时顺序节点
        if(currentPath==null||currentPath.length()>0){
            currentPath = zkClient.createEphemeralSequential(LOCK_PATH + "/", "lock");
        }
        //获取临时顺序节点
        List<String> childrens = zkClient.getChildren(LOCK_PATH);
        Collections.sort(childrens);
        //判断当前临时节点是否第一个节点
        if(currentPath.equals(LOCK_PATH+"/"+childrens.get(0))){
            return true;
        }else{
            int ws=Collections.binarySearch(childrens,currentPath.substring(6));
            beforePath=LOCK_PATH+"/"+childrens.get(ws-1);
        }
        return false;
    }

    @Override
    @SuppressWarnings("all")
    void waitFor()  {
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
        zkClient.subscribeDataChanges(beforePath,iZkDataListener);
        if(zkClient.exists(beforePath)){
            countDownLatch=new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(beforePath,iZkDataListener);
    }
}
