package com.xcclass.zl_lock.design.adapter;

public class Cooker {
    public JP110Inteface jp110Inteface;

    public Cooker(JP110Inteface jp110Inteface) {
        this.jp110Inteface = jp110Inteface;
    }

    public void cook() {
        jp110Inteface.connect();
        System.out.println("开始做饭");
    }

    public static void main(String[] args) {
        CN220Interface cn220Interface = new CN220Interfaceimpl();
        Adapter adapter = new Adapter(cn220Interface);
        Cooker cooker = new Cooker(adapter);
        cooker.cook();
    }
}
