package com.xcclass.zl_lock.design.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {
    private Object target;
    public InvocationHandlerImpl(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开启事务");
        Object invoke = method.invoke(target, args);
        System.out.println("提交事务");
        return invoke;
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userDao);
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();

        IUserDao iuserDao = (IUserDao)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        iuserDao.save();
    }
}
