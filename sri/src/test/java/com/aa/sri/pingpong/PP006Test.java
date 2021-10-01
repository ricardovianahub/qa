package com.aa.sri.pingpong;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String actual = keyEncoder.createKey("Alan", "Smith", "DFW");
        assertEquals("Alan-Smith-DFW", actual);
    }


}
