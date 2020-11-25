package com.algorithm.$2_sorting;

/**
 * 快速排序.
 *
 * 思路：从数组中找个元素做pivot(轴)进行分区操作(小于pivot的放数组左边，大于pivot的放数组右边)，再对数组左右进行一次分区操作，如此递归，直到排序完成
 *
 * 具体步骤：
 *
 * 复杂度：
 *  空间复杂度： O(n)
 *  时间复杂度： 最好、最坏、平均都是 O(nlogn)
 *
 * @author fuwb
 * @date 2020-11-24
 */
public class S04QuickSort {

    public void quickSort(int[] array) {
        doQuickSort(array, 0, array.length-1);
    }

    private void doQuickSort(int[] array, int start, int end) {
        // 终止条件
        if (start >= end) {
            return;
        }

        // 进行分区,返回基准下标
        int p = partitionByTwoSameDirectionPoint(array, start, end);

        // 对左右两部分进行操作
        doQuickSort(array, start, p-1);
        doQuickSort(array,p+1, end);
    }

    /**
     * 找个基准值，依次比较，分为大小两个区。
     * 使用两个方向相对的指针，找到符合条件数据时 两个指针数据进行互换
     * @param array
     * @param start
     * @param end
     * @return 分区基准的下标值
     */
    private int partitionByTwoOppositeDirectionPoint(int[] array, int start, int end) {
        // 用末尾元素作为基准
        int pivot = array[end];
        // 定义左右两个指针，左指针从左向右移动,遇到大于基准的元素则停止，开始从右向左移动右指针,遇到小于基准的元素则停止
        int leftIndex = start;
        int rightIndex = end-1;
        boolean changeFlag = false;
        for (int i = start; i < end; i++) {
            // 记录左指针当前位置
            leftIndex = i;
            // 遇到大于基准的元素则停止,开始从右向左移动右指针
            if (array[i] > pivot ) {
                changeFlag = true;
                for (int j = rightIndex; j >= leftIndex ; j--) {
                    // 记录右指针当前位置
                    rightIndex = j;
                    // 遇到小于基准的元素则停止
                    if (array[j] < pivot) {
                        // 交互元素
                        int temp = array[leftIndex];
                        array[leftIndex] = array[rightIndex];
                        array[rightIndex] = temp;
                        break;
                    }
                }
            }

            // 左右指针相同时终止
            if (leftIndex >= rightIndex ) {
                break;
            }
        }

        if (changeFlag) {
            // 基准元素换入中间区域
            array[end] = array[leftIndex];
            array[leftIndex] = pivot;
            return leftIndex;
        } else {
            return end;
        }
    }


    /**
     * 使用两个方向相同的指针(A和B)，小于基准时AB同时移动，大于基准时A移动，B不移动，然后A和B元素进行互换。
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static int partitionByTwoSameDirectionPoint(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        for(int j = start; j < end; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;

        System.out.println("i=" + i);
        return i;
    }
}
