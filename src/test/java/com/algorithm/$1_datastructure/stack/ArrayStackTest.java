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
class ArrayStackTest {

    ArrayStack arrayStack;
    @BeforeEach
    void init() {
        arrayStack = new ArrayStack(3);

    }

    @Test
    void pushTest() {
        arrayStack.push("1");
        assertEquals(1, arrayStack.getCount());
        arrayStack.push("2");
        assertEquals(2, arrayStack.getCount());
        assertTrue(arrayStack.push("3"));
        assertFalse(arrayStack.push("4"));
        assertFalse(arrayStack.push("5"));

        assertEquals(3, arrayStack.getCount());
    }

    @Test
    void popTest() {
        assertNull(arrayStack.pop());
        arrayStack.push("1");
        assertEquals("1", arrayStack.pop());

        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        assertEquals("3", arrayStack.pop());
        assertEquals("2", arrayStack.pop());
        assertEquals("1", arrayStack.pop());
        assertNull(arrayStack.pop());
    }
}