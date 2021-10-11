package com.aa.sri.pingpong;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PP002Test {

    // Client sends an integer gets back the factorial of that integer
    // Example: 1! = 1 - 2! = 2 - 3! = 6 - 4! = 24 - 5! = 120

    @Test
    void factorial1() {
        assertEquals(1, Factorial.of(1));
    }

    @Test
    void factorial2() {
        assertEquals(2, Factorial.of(2));
    }

    @Test
    void factorial3() {
        assertEquals(6, Factorial.of(3));
    }

    @Test
    void factorial4() {
        assertEquals(24, Factorial.of(4));
    }

}
