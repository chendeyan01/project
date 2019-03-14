package com.xcclass.zl_lock.design.adapter;

public class Adapter implements JP110Inteface {
    private CN220Interface cn220Interface;

    public Adapter(CN220Interface cn220Interface) {
        this.cn220Interface = cn220Interface;
    }

    @Override
    public void connect() {
        cn220Interface.connect();
    }
}
