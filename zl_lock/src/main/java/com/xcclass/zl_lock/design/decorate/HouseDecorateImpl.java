package com.xcclass.zl_lock.design.decorate;

public class HouseDecorateImpl extends HouseDecorate{
    public HouseDecorateImpl(House house){
        super(house);
    }
    @Override
    public void run() {
        super.run();
        System.out.println("墙上贴上新的壁纸");
    }
}
