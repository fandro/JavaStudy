package com.algorithm.$2_sorting;

/**
 * 插入排序
 *
 * @author fuwb
 * @date 2020-11-19
 */
public class S02InsertionSort {

    public void insertionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return ;
        }

        // 第一层是未排序区
        int length = array.length;
        for (int i = 1; i < length; i++) {
            // 取出一个元素item准备放入已排序区
            int item = array[i];
            // 从item的前一个元素开始比较，并移动数据
            // 理解变量j的2个含义：
            //  1. 循环开始时j初始值含义 ：从item前一个元素开始比较
            //  2. 循环结束时j值含义：第一个不符合条件的元素(item >= array[j] and item < array[j+1])
            int j = i - 1;
            for (; j >=0 ; j--) {
                if (array[j] > item ) {
                    // 移动数据
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j+1] = item;
        }
    }

}
