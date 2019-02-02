package com.xcclass.zl_lock.design.builder;

public class PersonDirector {
    public Person constructPerson(PersonBuilder pb){
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.buildPerson();
    }

    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector();
        PersonBuilder personBuilder = new ManBuilder();
        Person person = personDirector.constructPerson(personBuilder);
        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
    }
}
