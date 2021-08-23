package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class T0018FundamentalClassesAndMethods {

    @ParameterizedTest
    @CsvSource({"16,8", "20,10", "212, 106"})
    void multiplicationClassDoublesValue(int expected, int startValue) {
        T0018Multiplication t0018Multiplication = new T0018Multiplication();
        int actual = t0018Multiplication.doubleValue(startValue);

        assertEquals(expected, actual);
    }

    // STACK                                                |   HEAP
    // T0018Multiplication t0018Multiplication [ 001000 ]   | [ 001000 ] new T0018Multiplication()

    // Create a parameterized test that will receive the following parameters:
    // 1) result = 30 startValue = 10
    // 2) result = 45 startValue = 15
    // 2) result = 99 startValue = 33
    // Create a new method in T0018Multiplication called challenge. It should
    // receive the startValue as a parameter and return the expected result
    // Create this method by using the same steps as the first one. Make it pass,
    // then find a way to discover a formula that will resolve all the 3 cases
    // and any others

    @ParameterizedTest
    @CsvSource({"30,10", "45,15", "99,33"})
    void challenge(int expected, int startValue) {
        T0018Multiplication t0018Multiplication = new T0018Multiplication();
        int actual = t0018Multiplication.challenge(startValue);

        assertEquals(expected, actual);
    }


}
