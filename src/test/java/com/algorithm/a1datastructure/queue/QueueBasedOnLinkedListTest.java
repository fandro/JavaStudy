package com.algorithm.a1datastructure.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-11-17
 */
class QueueBasedOnLinkedListTest {

    QueueBasedOnLinkedList queueBasedOnLinkedList;
    @BeforeEach
    void setUp() {

    }

    @Test
    void enqueueTest() {
        queueBasedOnLinkedList = new QueueBasedOnLinkedList();
        assertTrue(queueBasedOnLinkedList.enqueue("1"));
        assertTrue(queueBasedOnLinkedList.enqueue("2"));
        assertTrue(queueBasedOnLinkedList.enqueue("3"));
        assertTrue(queueBasedOnLinkedList.enqueue("4"));
    }

    @Test
    void dequeueTest() {
        queueBasedOnLinkedList = new QueueBasedOnLinkedList();
        queueBasedOnLinkedList.enqueue("1");
        queueBasedOnLinkedList.enqueue("2");
        queueBasedOnLinkedList.enqueue("3");
        assertEquals("1", queueBasedOnLinkedList.dequeue());
        assertEquals("2", queueBasedOnLinkedList.dequeue());
        assertEquals("3", queueBasedOnLinkedList.dequeue());
        assertNull(queueBasedOnLinkedList.dequeue());

        queueBasedOnLinkedList.enqueue("1");
        queueBasedOnLinkedList.enqueue("2");
        queueBasedOnLinkedList.enqueue("3");
    }

    @DisplayName("队列数据迁移")
    @Test
    void queue_dataMove() {
        queueBasedOnLinkedList = new QueueBasedOnLinkedList();

        queueBasedOnLinkedList.enqueue("1");
        queueBasedOnLinkedList.enqueue("2");
        queueBasedOnLinkedList.enqueue("3");
        queueBasedOnLinkedList.dequeue();
        queueBasedOnLinkedList.dequeue();
        queueBasedOnLinkedList.enqueue("4");
        queueBasedOnLinkedList.enqueue("5");
        queueBasedOnLinkedList.enqueue("6");
        assertEquals("3", queueBasedOnLinkedList.findByIndex(0));
        assertEquals("4", queueBasedOnLinkedList.findByIndex(1));
        assertEquals("5", queueBasedOnLinkedList.findByIndex(2));
        assertEquals("6", queueBasedOnLinkedList.findByIndex(3));
    }
}