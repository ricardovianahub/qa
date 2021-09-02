package com.aa.sri.fundamentals.oop.compvsin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {
    // Person: Name, age, address

    @Test
    void personInit() {
        Person person = new Person(
            "John",
             "Doe",
            30,
            "123 Main Street"
        );

        assertEquals(30, person.getAge());
        assertEquals("123 Main Street", person.getAddress());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }

    @Test
    void person2Init() {
        Person2 person2 = new Person2(
                "John",
                "Doe",
                30,
                "123 Main Street"
        );
        assertEquals(30, person2.getAge());
        assertEquals("123 Main Street", person2.getAddress());
        assertEquals("John", person2.getFirstName());
        assertEquals("Doe", person2.getLastName());
    }

}
