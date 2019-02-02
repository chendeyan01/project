package com.xcclass.zl_lock.design.prototype;

import java.util.ArrayList;

public class Book implements  Cloneable{
    private Integer title;
    private ArrayList<String> image=new ArrayList<>();

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void addImg(String img) {
        image.add(img);
    }

    public void show(){
        System.out.println(getTitle());
        for (int i = 0; i < image.size(); i++) {
            String s =  image.get(i);
            System.out.println("图片："+s);
        }
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book book = (Book) super.clone();
        book.image= (ArrayList<String>) this.image.clone();
        return book;
    }
}
