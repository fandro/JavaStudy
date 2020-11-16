package com.algorithm.a1datastructure.array;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-11-13
 */
class LRUBasedArrayTest {

    @Test
    void offerTest() {
        LRUBasedArray<Integer> lruBasedArray = new LRUBasedArray(5);

        lruBasedArray.offer(1);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(2);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(3);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(4);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(2);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(5);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(3);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(6);
        System.out.println(lruBasedArray.toString());
        lruBasedArray.offer(7);
        System.out.println(lruBasedArray.toString());
    }
}