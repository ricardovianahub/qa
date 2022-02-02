package com.aa.sri.autowire;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AutowireTest {

    @Test
    void personAndName() {
        Name name = new Name();
        name.setFirst("John");
        name.setLast("Doe");
        Person person = new Person(name);
        assertNotNull(person.getName());
    }

}
