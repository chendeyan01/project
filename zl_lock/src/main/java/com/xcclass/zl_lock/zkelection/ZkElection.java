package com.xcclass.zl_lock.zkelection;

import org.I0Itec.zkclient.ZkClient;

public class ZkElection {
    public static final String CONNECTION="127.0.0.1:2181";
    private ZkClient zkClient=new ZkClient(CONNECTION);
    public static final String MASTER="master";


    public void tryMaster(){
        try {
            zkClient.createEphemeral(MASTER);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
