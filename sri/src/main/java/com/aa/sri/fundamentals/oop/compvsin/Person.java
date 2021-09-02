package com.aa.sri.fundamentals.oop.compvsin;

public class Person {
    private final Name name;
    private int age;
    private String address;

    public Person(String firstName, String lastName, int age, String address) {
        this.name = new Name(firstName, lastName);
        this.age = age;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return this.name.getFirstName();
    }

    public String getLastName() {
        return this.name.getLastName();
    }
}
