package com.xcclass.zl_lock.design.builder;

public class ManBuilder implements PersonBuilder {
    private Person person;
    public ManBuilder() {
        person=new Person();
    }

    @Override
    public void buildHead() {
       person.setHead("头部");
    }

    @Override
    public void buildBody() {
        person.setBody("身体");
    }

    @Override
    public void buildFoot() {
        person.setFoot("四肢");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
