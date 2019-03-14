package com.xcclass.zl_lock.design.singleton;
//线程安全的
//饿汉模式
public class SingletonDemo01 {
    private static SingletonDemo01 singletonDemo01=new SingletonDemo01();
    private SingletonDemo01(){
        System.out.println("####初始化成功####");
    }
    public static SingletonDemo01 getInstance(){
        return singletonDemo01;
    }

    public static void main(String[] args) {
        SingletonDemo01 instance1 = SingletonDemo01.getInstance();
        SingletonDemo01 instance2 = SingletonDemo01.getInstance();
        System.out.println(instance1==instance2);
    }
}
