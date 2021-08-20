package com.aa.sri.fundamentals.oop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RevertNamesAgeTest {

    // Why encapsulation? To divide and conquer. To deal with a problem in small batches
    // To hide those pieces. You don't want to be thinking about them while you fix another problem

    Encapsulation encapsulation = new Encapsulation(); // Hide the HOW .. "Hide" complexity.. divide/split complexity

    // Receive 3 parameters - first name, last name and age (in years)
    // Return a string with the names in reverse, last then first name, one space between them
    // and the estimated year of birth based on the age

     // -> [  [  ] -> [  ] -> [  ] -> [  ]  ] ->

    @ParameterizedTest
    @CsvSource({
            "John, Doe, 10, eoD nhoJ 2011",
            "Jane, Doe, 20, eoD enaJ 2001",
    })
    void reverseNamesWithBirthYear(String firstName, String lastName, int year, String expected) {
        RevertNamesAge revertNamesAge = new RevertNamesAge();

        String actual = revertNamesAge.revert(firstName, lastName, year);

        assertEquals(expected, actual);
    }

}
