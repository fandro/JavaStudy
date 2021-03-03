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
class CircularQueueBaseOnArrayTest {
    CircularQueueBaseOnArray CircularQueueBaseOnArray;
    @BeforeEach
    void setUp() {

    }

    @Test
    void enqueueTest() {
        CircularQueueBaseOnArray = new CircularQueueBaseOnArray(3);
        assertTrue(CircularQueueBaseOnArray.enqueue("1"));
        assertTrue(CircularQueueBaseOnArray.enqueue("2"));
        assertTrue(CircularQueueBaseOnArray.enqueue("3"));
        assertFalse(CircularQueueBaseOnArray.enqueue("4"));
    }

    @Test
    void dequeueTest() {
        CircularQueueBaseOnArray = new CircularQueueBaseOnArray(3);
        CircularQueueBaseOnArray.enqueue("1");
        CircularQueueBaseOnArray.enqueue("2");
        CircularQueueBaseOnArray.enqueue("3");
        assertEquals("1", CircularQueueBaseOnArray.dequeue());
        assertEquals("2", CircularQueueBaseOnArray.dequeue());
        assertEquals("3", CircularQueueBaseOnArray.dequeue());
        assertNull(CircularQueueBaseOnArray.dequeue());

        CircularQueueBaseOnArray.enqueue("1");
        CircularQueueBaseOnArray.enqueue("2");
        CircularQueueBaseOnArray.enqueue("3");
    }

    @DisplayName("队列数据迁移")
    @Test
    void queue_circularMove() {
        CircularQueueBaseOnArray = new CircularQueueBaseOnArray(5);

        CircularQueueBaseOnArray.enqueue("1");
        CircularQueueBaseOnArray.enqueue("2");
        CircularQueueBaseOnArray.enqueue("3");
        CircularQueueBaseOnArray.dequeue();
        CircularQueueBaseOnArray.dequeue();
        CircularQueueBaseOnArray.enqueue("4");
        CircularQueueBaseOnArray.enqueue("5");
        CircularQueueBaseOnArray.enqueue("6");
        CircularQueueBaseOnArray.enqueue("7");
        CircularQueueBaseOnArray.enqueue("8");
        CircularQueueBaseOnArray.enqueue("9");
        assertEquals("3", CircularQueueBaseOnArray.findByIndex(0));
        assertEquals("4", CircularQueueBaseOnArray.findByIndex(1));
        assertEquals("5", CircularQueueBaseOnArray.findByIndex(2));
        assertEquals("6", CircularQueueBaseOnArray.findByIndex(3));
    }
}