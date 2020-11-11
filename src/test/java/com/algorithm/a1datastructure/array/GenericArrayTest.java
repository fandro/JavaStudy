package com.algorithm.a1datastructure.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-11-05
 */
class GenericArrayTest {

    private GenericArray datas;

    @BeforeEach
    void setUp() {
        datas = new GenericArray<Integer>();
        for (int i = 0; i < 10; i++) {
            datas.add(i, 10 * i);
        }
    }

    @AfterEach
    void tearDown() {
        datas = null;
    }

    @Test
    void getCapacityTest() {
        assertEquals(10, datas.getCapacity());
    }

    @Test
    void countTest() {
        assertEquals(10, datas.count());
    }

    @Test
    void addTest() {
        datas = new GenericArray();
        int[] indexes = {-1,0,5,9,21};
        for (int i : indexes) {
            datas.add(i, 10*i);
        }
        assertEquals(4, datas.count());
        assertEquals(22, datas.getCapacity());
    }

    @Test
    void addFirstTest() {
        final int n = 1;
        datas.addFirst(n);
        assertEquals(n, datas.get(0));
    }

    @Test
    void addFirstTest_MoveData() {
        final int n = 1;
        datas.addFirst(n);

        assertEquals(n, datas.get(0));
        assertEquals(0, datas.get(1));
        assertEquals(50, datas.get(6));
        assertEquals(90, datas.get(10));
        assertEquals(20, datas.getCapacity());
    }

    @Test
    void addLastTest() {
        int n = 1000;
        datas.addLast(n);
    }

    @Test
    void deleteTest() {
        datas.delete(5);
        assertEquals(0, datas.get(0));
        assertEquals(60, datas.get(5));
        assertEquals(90, datas.get(8));
        assertEquals(null, datas.get(9));
    }

    @Test
    void deleteFirstTest() {
        datas.deleteFirst();
        assertEquals(10, datas.get(0));
        assertEquals(20, datas.get(1));
        assertEquals(90, datas.get(8));
        assertEquals(null, datas.get(9));
    }

    @Test
    void deleteLastTest() {
        datas.deleteLast();
        assertNull(datas.get(9));
        assertNotNull(datas.get(8));
    }

    @DisplayName("查找")
    @Test
    void findTest() {
        final int first = datas.find(0);
        final int mid = datas.find(60);
        final int last = datas.find(90);
        assertEquals(0,first);
        assertEquals(6,mid);
        assertEquals(9,last);
    }

    @DisplayName("containsTest 是否包含某元素")
    @Test
    void containsTest() {
        assertFalse(datas.contains(-1));
        assertTrue(datas.contains(0));
        assertFalse(datas.contains(5));
        assertTrue(datas.contains(10));
        assertTrue(datas.contains(60));
        assertTrue(datas.contains(90));
        assertFalse(datas.contains(100));
    }
}