package com.algorithm.$1_datastructure.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-11-16
 */
class LinkedListStackTest {


    LinkedListStack linkedListStack;
    @BeforeEach
    void init() {
        linkedListStack = new LinkedListStack(3);

    }

    @Test
    void pushTest() {
        linkedListStack.push("1");
        assertEquals(1, linkedListStack.getCount());
        linkedListStack.push("2");
        assertEquals(2, linkedListStack.getCount());
        assertTrue(linkedListStack.push("3"));
        assertFalse(linkedListStack.push("4"));
        assertFalse(linkedListStack.push("5"));

        assertEquals(3, linkedListStack.getCount());
    }

    @Test
    void popTest() {
        assertNull(linkedListStack.pop());
        linkedListStack.push("1");
        assertEquals("1", linkedListStack.pop());

        linkedListStack.push("1");
        linkedListStack.push("2");
        linkedListStack.push("3");
        linkedListStack.push("4");
        assertEquals("3", linkedListStack.pop());
        assertEquals("2", linkedListStack.pop());
        assertEquals("1", linkedListStack.pop());
        assertNull(linkedListStack.pop());
    }
}