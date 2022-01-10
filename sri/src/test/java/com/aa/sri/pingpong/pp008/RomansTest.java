package com.aa.sri.pingpong.pp008;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomansTest {
    @ParameterizedTest
    @CsvSource({"1,I", "5,V", "10,X", "50,L", "100,C", "500,D", "1000,M"})
    void singleLetters_story1(int argument, String expected) {
        // setup
        Romans romans = new Romans(); // all things being equal, instantiate
        // execution
        String actual = romans.convert(argument);
        // assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"2,II","3,III","20,XX","30,XXX","200,CC","300,CCC","2000,MM","3000,MMM"})
    void multipleLetters_story2(int argument, String expected) {
        // setup
        Romans romans = new Romans(); // all things being equal, instantiate
        // execution
        String actual = romans.convert(argument);
        // assert
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({"6,VI","11,XI"})
    void multipleLetters_story3(int argument, String expected) {
        // setup
        Romans romans = new Romans(); // all things being equal, instantiate
        // execution
        String actual = romans.convert(argument);
        // assert
        assertEquals(expected, actual);
    }
}
