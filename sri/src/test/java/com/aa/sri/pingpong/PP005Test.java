package com.aa.sri.pingpong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PP005Test {

    private Slide2 slide2;

    @BeforeEach
    void setup() {
        slide2 = new Slide2();
    }
    @ParameterizedTest
    @CsvSource({
            "ABC,ZAB",
            "XYZ,WXY"
    })
    void rotate(String argument, String expected) {
        assertEquals(expected, slide2.encode(argument));
    }

    @ParameterizedTest
    @CsvSource({
            "%", "[", "]", "\\#", "!", "{"
    })
    void rotateWrongCharacter(String badCharacter) {
        assertThrows(IllegalArgumentException.class,
                () -> slide2.encode(badCharacter)
        );
    }

}




// Implement Slide 2 encodingg - method receives one String, returns String where all
    // characters shift -1 in the alphabet, and A goes back to Z - all CAPS
    // Example: ABC = ZAB; XYZ - WXY

