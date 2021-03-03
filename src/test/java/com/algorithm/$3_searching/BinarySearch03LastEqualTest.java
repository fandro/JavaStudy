package com.algorithm.$3_searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author fuwb
 * @since 2021-02-24
 */
class BinarySearch03LastEqualTest {

    @Test
    void bsearchTest() {
        int[] arr = {1,3,4,5,6,8,8,8,11,18};

        BinarySearch03LastEqual bs = new BinarySearch03LastEqual();
        int lastIndex = bs.bsearch(arr, arr.length, 8);
        Assertions.assertEquals(7, lastIndex);
    }
}