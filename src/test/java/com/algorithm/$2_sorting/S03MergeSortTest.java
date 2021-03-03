package com.algorithm.$2_sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-11-23
 */
class S03MergeSortTest {

    @Test
    void mergeSortTest() {
        S03MergeSort mergeSort =  new S03MergeSort();
        int[] array = {8,3,1,8,5,6,9,15,7};
        int[] expectedArray = {1,3,5,6,7,8,8,9,15};
        mergeSort.mergeSort(array);
        assertArrayEquals(expectedArray, array);
    }
}