package com.xcclass.zl_lock.design.singleton;

public class User {
    private User(){

    }
    public static User getInstance(){
        return SingletonDemo04.INSTANCE.user;
    }
    private static  enum SingletonDemo04{
        INSTANCE;
        private User user;
        SingletonDemo04() {
            user=new User();
        }
    }

    public static void main(String[] args) {
        User instance1 = User.getInstance();
        User instance2 = User.getInstance();
        System.out.println(instance1==instance2);
    }
}
