package com.algorithm.$2_sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @date 2021-02-09
 */
class S06CountingSortTest {

    @Test
    void countingSortTest() {
        int[] array = {9,14,5,8,5,20,11,2,16,18,20,2,3,13,12,5,18};
        int[] expectedArray = new int[]{2,2,3,5,5,5,8,9,11,12,13,14,16,18,18,20,20};

        S06CountingSort countingSort = new S06CountingSort();
        countingSort.countingSort(array, array.length);

        assertArrayEquals(expectedArray, array);

    }
}