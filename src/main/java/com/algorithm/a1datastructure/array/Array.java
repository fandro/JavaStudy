package com.algorithm.a1datastructure.array;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * 数组
 *
 * @author fuwb
 * @date 2020-09-17
 */
public class Array {

    public Array() {
    }

    public static void main(String[] args) {
        int[] arrayRead = {9,4,7,5,0,2,0,7,2,7,3,4};
        //int[] array = new int[10];
        String[] array = {"0","1","2","3","4","5","6",null,null,null};
        String[] expectedArray01 = {"0","1","2","10","3","4","5","6",null,null};
        String[] expectedArray02 = {"0","1","2","10","11","4","5","6","3",null};
        String[] expectedArray03 = {"0","1","2","10","11","5","6","3",null,null};
        String[] expectedArray04 = {"0","1",null,null,null,"5","6","3",null,null};
        String[] expectedArray05 = {"0","1","5","6","3",null,null,null,null,null};

        // 数组下标随机访问
        final int i = arrayRead[3];
        System.out.println(i);

        // 数组插入(有顺序要求)
        // 插入到第3位
        int index1 = 3;
        String value1 = "10";

        insertArray01(array, index1, value1);
        assertArrayEquals(expectedArray01, array);

        // 数组插入(无顺序要求)
        int index2 = 4;
        String value2 = "11";
        insertArray02(array, index2, value2);
        assertArrayEquals(expectedArray02, array);

        // 数组删除(有顺序要求)
        int index3 = 5;
        deleteElement(array, index3);
        assertArrayEquals(expectedArray03, array);

        // 数组删除(无顺序要求)
        int index4 = 2;
        int index5 = 3;
        int index6 = 4;
        deleteElement2(array, index4, index5, index6);
        assertArrayEquals(expectedArray04, array);
        clearMark(array);
        assertArrayEquals(expectedArray05, array);
    }

    /**
     * 插入数据，移动后面所有数据.
     * @param array
     * @param index
     * @param value
     */
    private static void insertArray01(String[] array, int index, String value) {
        // 数据迁移
        for (int i = array.length-1; i >= index; i--) {
            array[i] = array[i-1];
        }
        // 插入数值
        array[index] = value;
    }


    /**
     * 插入数据，把原数据移动到尾部.
     * @param array
     * @param index
     * @param value
     */
    private static void insertArray02(String[] array, int index, String value) {
        // 查找末尾元素下标
        for (int j = index; j < array.length ; j++) {
            if (array[j] == null) {
                // 当前元素移动数组末尾
                array[j] = array[index];
                // 插入新元素
                array[index] = value;
                break;
            }
        }
    }

    /**
     * 数组删除(有顺序要求),删除元素后移动数据.
     * @param array
     * @param index3
     */
    private static void deleteElement(String[] array, int index3) {
        // 迁移数据
        for (int i = index3; i < array.length; i++) {
            if (i == array.length - 1 ) {
                // 最后一个元素，进行清空
                array[i] = null;
            } else {
                array[i] = array[i+1];
            }
        }

    }

    /**
     * 数组删除时只标记不真正删除，空间不足时清理并迁移数据。
     * @param array
     * @param index4
     * @param index5
     * @param index6
     */
    private static void deleteElement2(String[] array, int index4, int index5, int index6) {
        if (index4 < array.length) {
            array[index4] = null;
        }
        if (index5 < array.length) {
            array[index5] = null;
        }
        if (index6 < array.length) {
            array[index6] = null;
        }
    }

    private static void clearMark(String[] array) {
        // 使用双指针
        int start = 0;
        int end = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                start = i;
            }

        }
    }


}
