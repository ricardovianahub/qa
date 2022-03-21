package com.aa.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackTest { // Last in, First out

    @Test
    void stackAddOne() {
        Stack stack = new Stack();
        stack.push("one");
        assertEquals(1, stack.size());
    }

    @Test
    void stackAddAndRetrieveOne() {
        Stack stack = new Stack();
        stack.push("two");
        String popped = stack.pop();
        assertEquals("two", popped);
        assertEquals(0, stack.size());
    }

    @Test
    void stackAddAndRetrieveFour() {
        Stack stack = new Stack();
        stack.push("filler");
        stack.push("filler");
        stack.push("four");
        stack.push("five");
        stack.pop();
        String popped = stack.pop();
        assertEquals("four", popped);
        assertEquals(2, stack.size());
    }

}
