package com.algorithm.$2_sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-11-20
 */
class S02InsertionSortTest {

    @Test
    void insertionSortTest() {
        S03InsertionSort insertionSort = new S03InsertionSort();
        int[] array = {8,4,9,3,5,1};
        insertionSort.insertionSort(array);
        assertArrayEquals(new int[]{1,3,4,5,8,9}, array);
    }
}