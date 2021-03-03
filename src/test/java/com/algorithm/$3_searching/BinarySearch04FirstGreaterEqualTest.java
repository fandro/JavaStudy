package com.algorithm.$3_searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author fuwb
 * @since 2021-02-24
 */
class BinarySearch04FirstGreaterEqualTest {

    @Test
    void bsearchTest() {
        int[] arr = {3,4,6,7,10};
        BinarySearch04FirstGreaterEqual bs = new BinarySearch04FirstGreaterEqual();
        int index = bs.bsearch(arr, arr.length, 5);
        Assertions.assertEquals(2,index);
    }
}