package com.xcclass.zl_lock.design.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;
    public Object getInstance(Object target){
        this.target=target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开启");
        Object invoke = method.invoke(target, objects);
        System.out.println("提交事务");
        return invoke;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        CglibProxy cglibProxy = new CglibProxy();
        UserDao instance = (UserDao)cglibProxy.getInstance(userDao);
        instance.save();
    }
}
