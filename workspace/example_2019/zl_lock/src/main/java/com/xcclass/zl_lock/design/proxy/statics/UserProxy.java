package com.xcclass.zl_lock.design.proxy.statics;

public class UserProxy implements  IUserDao {
    private UserDao target;
    public UserProxy(UserDao target){
        this.target=target;
    }
    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserProxy userProxy = new UserProxy(userDao);
        userProxy.save();
    }
}
