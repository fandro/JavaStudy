package com.algorithm.a1datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-11-13
 */
class LRUBaseLinkedListTest {

    @Test
    void addTest() {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList(5);
        list.add(1);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.add(3);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        list.add(6);
        System.out.println(list);
        list.add(6);
        System.out.println(list);

    }
}