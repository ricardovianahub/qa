package com.aa.sri.pingpong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PP003Test {

    // Implement ROT-13 encoding - method receives one String, return ROT-13 encoded String (ALL CAPS, letters only)
    // ABCDEFGHIJKLMNOPQRSTWXYZ

    @ParameterizedTest
    @CsvSource({
            "A,N", "B,O", "C,P", "M,Z", // first 13
            "N,A", "z,Z"
    })
    void rotate(String argument, String expected) {
        assertEquals(expected, Rot13.encode(argument));
    }

    @Test
    void rotateWrongCharacter() {
        assertThrows(IllegalArgumentException.class,
                () -> Rot13.encode("%")
        );
    }

}
