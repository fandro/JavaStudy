package com.algorithm.$3_searching;

/**
 * 二分查找.
 * 简单情况： 有序数据，没有重复元素
 *
 * @author fuwb
 * @since 2021-02-20
 */
public class BinarySearch01Simple {

    /**
     * 二分查找.
     * @param arr 有序数组
     * @param size 数组大小
     * @param value 要查找的值
     * @return
     */
    public int binarySearchByLoop(int[] arr, int size, int value) {
        // 确定区间边界值 low-high
        int low = 0;
        int high = size - 1;

        // 循环退出条件 low <= high
        while (low <= high) {
            // 计算区间的中间下标
            // 正常写法
            //int mid = (low + high) / 2;
            // 优化1: 防止(low + high)相加后数据溢出，修改为减法形式
            //int mid = low + (high-low)/2;
            // 优化2:  (high-low)/2 => (high-low) >> 1
            int mid = low + ((high-low) >> 1);
            // 比较value与中间值
            if (value == arr[mid]) {
                return mid;
            } else if (value < arr[mid]) {
                // 移动high到mid位置, mid-1 表示：忽略arr[mid]元素，左移一个元素
                high = mid - 1;
            } else if (value > arr[mid]) {
                // 移动low到mid位置，mid+1 表示 忽略arr[mid]元素，右移一个元素
                low = mid + 1;
            }

            // 当high==low && value!=arr[mid]时，这个写法 high=mid; low = mid; 会导致死循环。
        }

        return -1;
    }

    public int binarySearchByRecursion(int[] arr, int size, int value) {
        int low = 0;
        int high = size -1;

        return doBinarySearchByRecursion(arr,low,high,value);
    }

    private int doBinarySearchByRecursion(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low)>>1);
        if (value == arr[mid]) {
            return mid;
        } else if (value < arr[mid]) {
            high = mid - 1;
        } else if (value > arr[mid]) {
            low = mid + 1;
        }

        return doBinarySearchByRecursion(arr, low, high, value);
    }

}

