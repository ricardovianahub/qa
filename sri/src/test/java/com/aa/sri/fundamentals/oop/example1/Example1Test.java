package com.aa.sri.fundamentals.oop.example1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Example1Test {

    private Example1 example1;

    @ParameterizedTest
    @CsvSource({
            "'',",
            "'',''",
            "a,a",
            "'ab,ba',ab",
            "'def,dfe,edf,efd,fde,fed',def",
    })
    void buildAnagramsAll(String expectedString, String argument) {
        // setup
        example1 = new Example1(Example1.STRATEGY.ALL);
        String[] expected = expectedString.split(",");
        // execution
        String[] actual = example1.buildAnagrams(argument);

        Arrays.sort(actual);

        // assertEquals
        assertTrue(Arrays.equals(expected, actual),
                "Actual = " + Arrays.toString(actual)
        );
    }

}
