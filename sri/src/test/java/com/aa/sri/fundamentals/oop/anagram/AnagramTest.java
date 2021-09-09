package com.aa.sri.fundamentals.oop.anagram;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AnagramTest {

    private Anagram anagram;

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
        anagram = new Anagram(Anagram.STRATEGY.ALL);
        String[] expected = expectedString.split(",");
        // execution
        String[] actual = anagram.buildAnagrams(argument);

        Arrays.sort(actual);

        // assertEquals
        assertTrue(Arrays.equals(expected, actual),
                "Actual = " + Arrays.toString(actual)
        );
    }

}
