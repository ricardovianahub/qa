package com.aa.sri.pingpong;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PP001Test {

    // The client is expected to provide integer value and receive value divided by 7
    @ParameterizedTest
    @CsvSource({"70,10", "140,20", "210, 30"})
    void divideby7(int argument, float expected) {

        // setup
        Divider divider = new Divider();

        // execution
        float actual = divider.by7(argument);

        // assertion
        assertEquals(expected, actual);
    }


}
