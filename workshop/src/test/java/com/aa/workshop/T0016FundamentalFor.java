package com.aa.workshop;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class T0016FundamentalFor {

    @Test
    void basicForeachLoop() {
        List<String> strings = new ArrayList<>();

        strings.add("one");
        strings.add("two");
        strings.add("three");

        for (String string : strings) {
            System.out.println("=====(BEGIN)=====");
            System.out.println(string);
            System.out.println("======(END)======");
        }
    }

    @Test
    void basicForLoopWithIndex() {
        for (int i = 0; i < 5; i++) { // i = i + 1;
            System.out.println(i);
        }
        for (int i = 0; i < 5; i+=2) { // i = i + 2;
            System.out.println(i);
        }
        for (int i = 0; i < 5; i+=3)     { // i = i + 3;
            System.out.println(i);
        }
    }

    // Write a for loop that will show all whole number from 10 to 1 (inclusive) - in descending order

    @Test
    void challenge() {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
        for (int i = 20; i < 31; i++) {
            System.out.println(i);
        }
        for (int i = 100; i >=80; i-=7) {
            System.out.println(i);
        }
    }
}

