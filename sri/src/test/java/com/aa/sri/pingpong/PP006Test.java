package com.aa.sri.pingpong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PP006Test {

    // Call the service http://ricbox.com/passengers and generate an encoded key in the following format
    // firstName + "-" + lastName + "-" + origination

    @Test
    void createKeyJohn() {
        KeyEncoder keyEncoder = new KeyEncoder();
        String actual = keyEncoder.createKey("John", "Doe", "DFW");
        assertEquals("John-Doe-DFW", actual);
    }

    @Test
    void createKeyAlan() {
        KeyEncoder keyEncoder = new KeyEncoder();
        String actual = keyEncoder.createKey("Alan", "Smith", "ORD");
        assertEquals("Alan-Smith-ORD", actual);
    }

    @Test
    void createKeyJames() {
        KeyEncoder keyEncoder = new KeyEncoder();
        String actual = keyEncoder.createKey("James", "Thomas", "DFW");
        assertEquals("James-Thomas-DFW", actual);
    }

    @Test
    void nullParametersThrowException() {
        KeyEncoder keyEncoder = new KeyEncoder();
        assertThrows(
                IllegalArgumentException.class,
                () -> keyEncoder.createKey("Joe", null, "DFW")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> keyEncoder.createKey(null, "Smith", "DFW")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> keyEncoder.createKey("Joe", "Smith", null)
        );
    }


}
