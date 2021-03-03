package com.algorithm.$2_sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-11-20
 */
class S02SelectionSortTest {

    @Test
    void selectionSortTest() {
        int[] array = {3,8,4,2,9,1,6};
        S02SelectionSort s02SelectionSort = new S02SelectionSort();
        s02SelectionSort.SelectionSort(array);
        assertArrayEquals(new int[]{1,2,3,4,6,8,9}, array);
    }
}