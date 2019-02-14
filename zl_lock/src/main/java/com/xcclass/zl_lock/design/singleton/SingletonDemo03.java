package com.xcclass.zl_lock.design.singleton;

public class SingletonDemo03 {

    private SingletonDemo03(){

    }
    public static class SingletonInstance{
        private static SingletonDemo03 singletonDemo03=new SingletonDemo03();
    }
    public static  SingletonDemo03 getInstance(){
        return SingletonInstance.singletonDemo03;
    }

    public static void main(String[] args) {
        SingletonDemo03 instance1 = SingletonDemo03.getInstance();
        SingletonDemo03 instance2 = SingletonDemo03.getInstance();
        System.out.println(instance1==instance2);
    }
}
