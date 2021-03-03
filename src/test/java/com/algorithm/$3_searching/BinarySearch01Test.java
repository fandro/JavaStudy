package com.algorithm.$3_searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO
 *
 * @author fuwb
 * @since 2021-02-20
 */
class BinarySearch01Test {

    @Test
    void binarySearchByLoopTest() {
        int[] array = {1,3,4,7,10,14,16,20,25,36,41,44,45,50};

        BinarySearch01Simple bs = new BinarySearch01Simple();
        int i = bs.binarySearchByLoop(array, array.length, 4);
        assertEquals(2, i);
    }

    @Test
    void binarySearchByRecursionTest() {
        int[] array = new int[]{1,3,4,7,10,14,16,20,25,36,41,44,45,50};

        BinarySearch01Simple bs = new BinarySearch01Simple();
        int i = bs.binarySearchByRecursion(array, array.length, 3);
        assertEquals(1, i);
    }
}