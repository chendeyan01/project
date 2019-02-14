package com.xcclass.zl_lock.design.template;

public class Client {
    public static void main(String[] args) {
        BankTemplateMethod bankTemplateMethod=new DrawMoney();
        bankTemplateMethod.process();
    }
}
