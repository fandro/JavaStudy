package com.algorithm.$3_searching;

/**
 * 数据重复,查找最后一个小于等于给定值的元素
 *
 * @author fuwb
 * @since 2021-02-24
 */
public class BinarySearch05LastLessEqual {

    public int bsearch(int[] arr, int size, int value) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + ((high - low)>>1);

            if (value < arr[mid]) {
                high = mid - 1;
            } else {
                if ((mid == size - 1) || (arr[mid + 1] > value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
