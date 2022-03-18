package com.aa.sri.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    void add1() {
        Stack stack = new Stack();
        stack.push("one");
        assertEquals(1, stack.size());
    }

    @Test // Change parameters on each test
    void add1Pop1() {
        Stack stack = new Stack();
        stack.push("two");
        String result = stack.pop();
        assertEquals(0, stack.size());
        assertEquals("two", result);
    }

    @Test // Change parameters on each test
    void add4Pop4() {
        Stack stack = new Stack();
        stack.push("one");
        stack.push("two");
        stack.push("four");
        stack.push("six");
        stack.pop();
        String result = stack.pop();
        assertEquals(2, stack.size());
        assertEquals("four", result);
    }

}
