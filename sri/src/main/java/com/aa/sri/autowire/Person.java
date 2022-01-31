package com.aa.sri.autowire;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private final Name name;

    public Person(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
