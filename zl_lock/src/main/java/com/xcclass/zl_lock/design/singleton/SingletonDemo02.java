package com.xcclass.zl_lock.design.singleton;
//线程不安全的
//懒汉模式
public class SingletonDemo02 {
    private static SingletonDemo02 singletonDemo02;
    private  SingletonDemo02(){
        System.out.println("实例初始化");
    }
    public static SingletonDemo02 getInstance(){
        if(singletonDemo02==null){
            singletonDemo02=new SingletonDemo02();
        }
        return singletonDemo02;
    }

    public static void main(String[] args) {

        SingletonDemo02 instance1 = SingletonDemo02.getInstance();
        SingletonDemo02 instance2 = SingletonDemo02.getInstance();
        System.out.println(instance1==instance2);
    }
}
