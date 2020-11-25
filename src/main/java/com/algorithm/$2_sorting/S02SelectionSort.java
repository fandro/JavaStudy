package com.algorithm.$2_sorting;

/**
 * 选择排序
 * 总体思路：每次从未排序区取出一个最小值放入已排序区末尾
 *
 * 具体步骤：
 * 1. 排序过程分为2个区：未排序区和已排序区。
 * 2. 初始状态：全部都是未排序区，已排序区为空
 * 3. 未排序区每次取出一个元素A(第一层循环)
 * 4. 建立一个最小值指针，元素A与元素B进行比较，如果B小于A，则把指针指向B，然后B继续与剩余数据比较，依次类推
 * 7. 排序完成状态：未排序区为空，全部数据在已排序区
 *
 * 复杂度：
 *  空间复杂度： O(1)
 *  时间复杂度： 最好、最坏、平均都是O(n^2)
 *
 * @author fuwb
 * @date 2020-11-20
 */
public class S02SelectionSort {

    public void SelectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        // 长度为n的数组，依次获取位置i，，
        int length = array.length;
        for (int i = 0; i < length; i++) {
            // 记录最小值下标
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                if (array[j] < array[minIndex] ) {
                    minIndex = j;
                }
            }

            // 交互位置
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }


}
