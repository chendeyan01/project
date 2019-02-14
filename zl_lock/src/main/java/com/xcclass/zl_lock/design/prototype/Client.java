package com.xcclass.zl_lock.design.prototype;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book=new Book();
        book.setTitle(1);
        book.addImg("book1");

        Book book2= book.clone();
       book2.setTitle(2);
        book2.addImg("book2");
        book.show();
        System.out.println("==================================");
        book2.show();
      //  System.out.println(book.getTitle()==book2.getTitle());
    }
}
