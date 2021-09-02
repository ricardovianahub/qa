package com.aa.sri.fundamentals.oop.compvsin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NameTest {

    //  - Abbreviation (return the first 2 letters of each name, in caps, no spaces)
    //            - Last name + comma + first name
    //            - First initial dot last name
    //            - Just display first and last names in order with a space between name

    @ParameterizedTest
    @CsvSource({
            "Bob,Bobby,BB",
            "John,Doe,JD",
            "John,Smith,JS",
    })
    void abbreviation(String firstName, String lastName, String expected) {
        Name name = new Name(firstName, lastName);

        assertEquals(expected, name.abbreviation());
    }

    @ParameterizedTest
    @CsvSource({
            "Bob,Bobby,'Bobby,Bob'",
            "John,Doe,'Doe,John'",
            "John,Smith,'Smith,John'",
    })
    void lastFirst(String firstName, String lastName, String expected) {
        Name name = new Name(firstName, lastName);

        assertEquals(expected, name.lastFirst());
    }

}
