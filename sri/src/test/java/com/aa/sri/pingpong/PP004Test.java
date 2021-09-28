package com.aa.sri.pingpong;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PP004Test {

    // Implement Slide 1 encodingg - method receives one String, returns String where all
    // characters shift +1 in the alphabet, and Z goes back to A - all CAPS
    // Example: ABC = BCD; XYZ - YZA
    @ParameterizedTest
    @CsvSource({
//            "A,N", "B,O", "C,P", "M,Z", // first 13
//            "N,A", "O,B", "P,C", "Z,M",
//            "ABC,NOP",
//            "BCM,OPZ"
            "ABC,BCD",
            "XYZ,YZA"
    })
    void rotate(String argument, String expected) {
        assertEquals(expected, Rot13.encode(argument));
    }

    @ParameterizedTest
    @CsvSource({
            "%", "[", "]", "\\#", "!", "{"
    })
    void rotateWrongCharacter(String badCharacter) {
        assertThrows(IllegalArgumentException.class,
                () -> Rot13.encode(badCharacter)
        );
    }

    @Test
    void getsExceptionObject() {
        Exception actual = Rot13.example();
        assertEquals(IllegalArgumentException.class, actual.getClass());
    }

}
