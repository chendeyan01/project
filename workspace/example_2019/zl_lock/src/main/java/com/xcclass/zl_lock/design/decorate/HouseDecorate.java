package com.xcclass.zl_lock.design.decorate;

public class HouseDecorate {
    private House house;
    public HouseDecorate(House house){
        this.house=house;
    }
    public void run(){
        house.run();
    }
}
