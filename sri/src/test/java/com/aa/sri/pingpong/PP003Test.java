package com.aa.sri.pingpong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PP003Test {

    // Implement ROT-13 encoding - method receives one String, return ROT-13 encoded String (ALL CAPS, letters only)
    // ABCDEFGHIJKLMNOPQRSTWXYZ

    @Test
    void rotateA() {
        String argument = "A";
        String expected = "N";

        assertEquals(expected, Rot13.encode(argument));
    }
    @Test
    void rotateB() {
        String argument = "B";
        String expected = "O";

        assertEquals(expected, Rot13.encode(argument));
    }
    @Test
    void rotateWrongCharacter() {
        assertThrows(IllegalArgumentException.class,
                () -> Rot13.encode("%")
        );
    }

}
