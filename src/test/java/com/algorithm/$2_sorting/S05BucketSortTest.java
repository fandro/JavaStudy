package com.algorithm.$2_sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @since 2021-02-07
 */
class S05BucketSortTest {

    @Test
    void bucketSortTest() {
        S05BucketSort bucketSort = new S05BucketSort();
        int[] array = {9,14,5,8,5,20,11,2,16,18,20,2,3,13,12,5,18};
        int bucketSize = 5;
        bucketSort.bucketSort(array, bucketSize);

        int[] expectedArray = new int[]{2,2,3,5,5,5,8,9,11,12,13,14,16,18,18,20,20};
        assertArrayEquals(expectedArray, array);
    }
}


