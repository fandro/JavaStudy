package com.algorithm.$3_searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author fuwb
 * @since 2021-02-24
 */
class BinarySearch02FirstEqualTest {

    @Test
    void bsearchTest() {
        int[] arr = {1,3,4,5,6,8,8,8,11,18};
        BinarySearch02FirstEqual bs = new BinarySearch02FirstEqual();

        int firstIndex = bs.bsearch(arr, arr.length, 8);

        Assertions.assertEquals(5,firstIndex);
    }
}