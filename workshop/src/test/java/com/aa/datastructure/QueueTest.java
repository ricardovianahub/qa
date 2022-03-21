package com.aa.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    void queueAddOne() {
        Queue queue = new Queue();
        queue.push("one");
        assertEquals(1, queue.size());
    }

//    @Test
    void queueAddAndRetrieveOne() {
        Queue queue = new Queue();
        queue.push("two");
        String popped = queue.pop();
        assertEquals("two", popped);
        assertEquals(0, queue.size());
    }

//    @Test
    void queueAddAndRetrieveFour() {
        Queue queue = new Queue();
        queue.push("filler");
        queue.push("filler");
        queue.push("four");
        queue.push("five");
        queue.pop();
        String popped = queue.pop();
        assertEquals("four", popped);
        assertEquals(2, queue.size());
    }


}
