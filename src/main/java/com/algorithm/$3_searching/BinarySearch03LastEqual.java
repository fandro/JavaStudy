package com.algorithm.$3_searching;

/**
 * 重复数据，查找最后一个值等于给定值的元素
 *
 * @author fuwb
 * @since 2021-02-24
 */
public class BinarySearch03LastEqual {


    public int bsearch(int[] arr, int size, int value) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + ((high - low)>>1);

            if (value < arr[mid]) {
                high = mid - 1;
            } else if (value > arr[mid]) {
                low = mid + 1;
            } else {
                // 如果 mid 等于 size-1，那这个元素已经是数组的最后一个元素，那它肯定是我们要找的；
                // 如果 mid 不等于 size-1，但 arr[mid] 的后一个元素 arr[mid+1] 不等于 value，那也说明 arr[mid] 就是我们要找的最后一个值等于给定值的元素。
                if (mid == (size-1) || value != arr[mid + 1]) {
                    return mid;
                } else {
                    // 元素在 [mid+1, high] 之间
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
