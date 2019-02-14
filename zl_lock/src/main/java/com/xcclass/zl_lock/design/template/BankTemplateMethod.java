package com.xcclass.zl_lock.design.template;

public abstract class BankTemplateMethod {
    public void takeNumber(){
        System.out.println("排队取号");
    }
    abstract void transact();
    public void evaluate(){
        System.out.println("评价反馈");
    }
    public void process(){
        takeNumber();
        transact();
        evaluate();

    }
}
