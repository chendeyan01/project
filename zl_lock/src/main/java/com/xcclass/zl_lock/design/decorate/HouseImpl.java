package com.xcclass.zl_lock.design.decorate;

public class HouseImpl implements House {
    @Override
    public void run() {
        System.out.println("我是没有装修的房子");
    }
}
