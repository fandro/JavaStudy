package com.algorithm.$1_datastructure.$3_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-11-17
 */
class ArrayQueueTest {

    ArrayQueue arrayQueue;
    @BeforeEach
    void setUp() {

    }

    @Test
    void enqueueTest() {
        arrayQueue = new ArrayQueue(3);
        assertTrue(arrayQueue.enqueue("1"));
        assertTrue(arrayQueue.enqueue("2"));
        assertTrue(arrayQueue.enqueue("3"));
        assertFalse(arrayQueue.enqueue("4"));
    }

    @Test
    void dequeueTest() {
        arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        assertEquals("1", arrayQueue.dequeue());
        assertEquals("2", arrayQueue.dequeue());
        assertEquals("3", arrayQueue.dequeue());
        assertNull(arrayQueue.dequeue());

        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
    }

    @DisplayName("队列数据迁移")
    @Test
    void queue_dataMove() {
        arrayQueue = new ArrayQueue(5);

        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");
        arrayQueue.enqueue("6");
        assertEquals("3", arrayQueue.findByIndex(0));
        assertEquals("4", arrayQueue.findByIndex(1));
        assertEquals("5", arrayQueue.findByIndex(2));
        assertEquals("6", arrayQueue.findByIndex(3));
    }

}