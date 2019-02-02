package com.xcclass.zl_lock.design.proxy.dynamic.jdk;

public class UserDao implements  IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据成功");
    }
}
