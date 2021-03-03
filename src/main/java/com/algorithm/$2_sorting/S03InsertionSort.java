package com.algorithm.$2_sorting;

/**
 * 插入排序
 * 总体思路：
 *    从未排序区中取出一个数据，在已排序区中找到合适位置插入，并保证已排序区中数据有序
 * 具体步骤：
 * 1. 排序过程分为2个区：未排序区和已排序区。
 * 2. 初始状态：已排序区只有第一个元素，剩下都是未排序区
 * 3. 从未排序区数据取出一个数据a
 * 4. 数据A与排序区元素中B依次进行比较
 * 5. 数据A小于元素中B时元素B后移
 * 6. 数据A大于等于元素中B时，插入到元素B后面
 * 7. 排序完成状态：未排序区为空，全部数据在已排序区
 *
 * 复杂度：
 *  空间复杂度： O(1)
 *  时间复杂度： 最好O(n)、最坏O(n^2)、平均O(n^2)
 *
 * @author fuwb
 * @since 2020-11-19
 */
public class S03InsertionSort {

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
