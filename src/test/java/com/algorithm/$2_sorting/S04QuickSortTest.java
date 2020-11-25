package com.algorithm.$2_sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-11-25
 */
class S04QuickSortTest {

    @Test
    void quickSortTest() {
        int[] array = {3,5,8,1,2,9,4,7,6};
        int[] expectedArray = {1,2,3,4,5,6,7,8,9};

        S04QuickSort quickSort = new S04QuickSort();
        quickSort.quickSort(array);
        assertArrayEquals(expectedArray, expectedArray);
    }
}