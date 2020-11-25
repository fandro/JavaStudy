package com.algorithm.$2_sorting;

import java.util.Arrays;

/**
 * 冒泡排序.
 *
 * 总体思路：一轮冒泡过程中两两比较，大的元素后移，未排序区最大元素移动排序中末尾
 *
 * 具体步骤：
 * 1. 排序过程分为2个区：未排序区和已排序区。
 * 2. 初始化状态时整个数组是未排序区
 * 3. 一轮排序中对未排序区两两比较，前面元素比较后面大的则进行元素交互位置
 * 4. 元素交互移动到排序区最前时，本轮冒泡结束
 * 5. 如果一轮过后没有数据发生交换，正在未排序区的数据已经是有序了，此时直接退出循环
 *
 * 复杂度：
 *  空间复杂度： O(1)
 *  时间复杂度： 最好O(n)、最坏O(n^2)、平均O(n^2)
 *
 * @author fuwb
 * @date 2020-08-25
 */
public class S01BubbleSort {

    public static void main(String[] args) {

        int[] a = {9,8,5,8,4,7,2,6};
        // 部分数据有序(前3个元素有序)
        int[] b = {3,4,5,9,8,7,6};
        bubbleSort(a, a.length);
        bubbleSortWithOptimize(b, b.length);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a, int n) {

        // 第一层循环表示要进行n轮排序，开始时：未排序区大小=n，已经排序区大小=0，每循环一次未排序区域大小减少1，已经排序区域增加1。
        for (int i = 0; i < n; i++) {

            // 第二层循环表示对未排序区中的k个数据进行比较
            // k表示未排序边界值，每一轮冒泡后未排序区边界减1，排序区边界加1。
            // k之前是未排序区，k之后是已排序区

            // 数组最大下标
            int maxIndex = (n-1);
            // 未排序区和排序区的边界下标，k每次减少1
            int k = maxIndex - i;
            for (int j = 0; j < k; j++) {
                // a1大于a2时 交互位置
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

        }
    }

    /**
     * 冒泡排序优化
     * 优化：如果一次排序过后没有发生数据交换，则说未排序区中数据已经是有序的，所以可以直接结束了。
     */
    private static void bubbleSortWithOptimize(int[] a, int n) {

        // 第一层循环表示要进行n轮排序，开始时：未排序区大小=n，已经排序区大小=0，每循环一次未排序区域大小减少1，已经排序区域增加1。
        for (int i = 0; i < n; i++) {
            // 第二层循环表示对未排序区中的k个数据进行比较
            // k表示未排序边界值，每一轮冒泡后未排序区边界减1，排序区边界加1。
            // k之前是未排序区，k之后是已排序区

            // 数组最大下标
            int maxIndex = (n-1);
            // 未排序区和排序区的边界下标，k每次减少1
            int k = maxIndex - i;
            // 未排序区是否已经有序（优化部分）
            boolean isOrdered = true;

            for (int j = 0; j < k; j++) {
                // a1大于a2时 交互位置
                if( a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    isOrdered = false;
                }
            }

            if (isOrdered) {
                // 未排序区没有发生数据交换，说明数据已经有序，直接退出，无需再排序
                break;
            }
        }

    }
}
