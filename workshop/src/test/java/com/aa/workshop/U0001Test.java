package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class U0001Test {

    // Outcome: receive 2 numbers, return one of them multiplied by the other
    // Example: (2,3) returns 6; (5,4) returns 20; (9,10) returns 90
    // Generalize the solution with at least 3 scenarios (rule of thumb not law)

    @Test
    void multiply() {
        Multiplication multiplication = new Multiplication();

        int argument1 = 2;
        int argument2 = 3;

        int result = multiplication.of(argument1, argument2);

        assertEquals(6, result);
    }

    @Test
    void multiply2() {
        Multiplication snowball = new Multiplication();

        int argument1 = 5;
        int argument2 = 4;

        int pineapple = snowball.of(argument1, argument2);

        assertEquals(20, pineapple);
    }

    @Test
    void multiply3() {
        Multiplication snowball = new Multiplication();

        int argument1 = 9;
        int argument2 = 10;

        int pineapple = snowball.of(argument1, argument2);

        assertEquals(90, pineapple);
    }
}
