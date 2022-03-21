package com.aa.sri.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    void add1() {
        Queue queue = new Queue();
        queue.push("one");
        assertEquals(1, queue.size());
    }

    @Test
    void add1Pop1() {
        Queue queue = new Queue();
        queue.push("six");
        String result = queue.pop();
        assertEquals(0, queue.size());
        assertEquals("six", result);
    }

    @Test // Change parameters on each test
    void add4Pop4() {
        Queue queue = new Queue();
        queue.push("zero");
        queue.push("one");
        queue.push("two");
        queue.push("four");
        queue.push("six");
        queue.pop();
        String result = queue.pop();
        assertEquals(3, queue.size());
        assertEquals("one", result);
    }
}
