package com.aa.sri.pingpong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PP004Test {

    // Implement Slide 1 encodingg - method receives one String, returns String where all
    // characters shift +1 in the alphabet, and Z goes back to A - all CAPS
    // Example: ABC = BCD; XYZ - YZA

    private Slide1 slide1;

    @BeforeEach
    void setup() {
        slide1 = new Slide1();
    }

    @ParameterizedTest
    @CsvSource({
            "ABC,BCD",
            "XYZ,YZA"
    })
    void rotate(String argument, String expected) {
        assertEquals(expected, slide1.encode(argument));
    }

    @ParameterizedTest
    @CsvSource({
            "%", "[", "]", "\\#", "!", "{"
    })
    void rotateWrongCharacter(String badCharacter) {
        assertThrows(IllegalArgumentException.class,
                () -> slide1.encode(badCharacter)
        );
    }

}
