package com.aa.sri.fundamentals.oop.lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LambdaTest {

    @Test
    void anonymousClass() {
        Test1 test1 = new Test1Class();

        Test1 test1Anonymous = new Test1() {
            @Override
            public String tellme() {
                return "hi";
            }
        };

        Test1 test1lambda = () -> "hi";

        Test2 test2 = (one, two) -> one.equals(two);

        Repeat repeat = (text, times) -> {
          StringBuilder result = new StringBuilder();

            for (int i = 0; i < times; i++) {
                result.append(text);
            }

            System.out.println("calling repeat object");

            return result.toString();
        };

        System.out.println("==(BEGIN)==");

        assertEquals("hi", test1.tellme());
        assertEquals("hi", test1Anonymous.tellme());
        assertEquals("hi", test1lambda.tellme());
        assertTrue(test2.areSame("abc", "abc"));
        assertEquals("abcabcabc", repeat.multiple("abc", 3));

        System.out.println("==(END)==");

    }

    private interface Test1 {
        String tellme();
    }

    private interface Test2 {
        boolean areSame(String one, String two);
    }

    private interface Repeat {
        String multiple(String text, int times);
    }

    private class Test1Class implements Test1 {
        @Override
        public String tellme() {
            return "hi";
        }
    }

}
