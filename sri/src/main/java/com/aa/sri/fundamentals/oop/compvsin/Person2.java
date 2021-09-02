package com.aa.sri.fundamentals.oop.compvsin;

//                    IS A (WRONG)
public class Person2 extends Name {

    private int age;
    private String address;

    public Person2(String firstName, String lastName, int age, String address) {
        super(firstName, lastName);
        this.age = age;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}

// BAD: object.method().anotherMethod()........   <<-- Breaking the Law of Demeter
