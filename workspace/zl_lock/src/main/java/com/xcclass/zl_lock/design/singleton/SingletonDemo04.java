package com.xcclass.zl_lock.design.singleton;

public class SingletonDemo04 {
    private static SingletonDemo04 singletonDemo04;
    private SingletonDemo04(){}
    public static SingletonDemo04 getInstance(){
        if(singletonDemo04==null){
            synchronized (SingletonDemo04.class){
                if(singletonDemo04==null){
                    singletonDemo04=new SingletonDemo04();
                }
            }
        }


        return singletonDemo04;
    }

    public static void main(String[] args) {
        SingletonDemo04 instance1 = SingletonDemo04.getInstance();
        SingletonDemo04 instance2 = SingletonDemo04.getInstance();
        System.out.println(instance1==instance2);
    }

}
