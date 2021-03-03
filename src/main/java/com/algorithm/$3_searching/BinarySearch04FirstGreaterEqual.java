package com.algorithm.$3_searching;

/**
 * 重复数据，查找第一个大于等于给定值的元素.
 *
 * @author fuwb
 * @since 2021-02-24
 */
public class BinarySearch04FirstGreaterEqual {

    public int bsearch(int[] arr, int size, int value) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + ((high - low)>>1);

            if (value <= arr[mid]) {
                // 如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
                // 如果 mid 不等于0，但 arr[mid] 的前一个元素 arr[mid-1] 小于 value，那也说明 arr[mid] 就是我们要找的第一个值大于等于给定值的元素。
                if (mid == 0 || value > arr[mid - 1]) {
                    return mid;
                } else {
                    // 元素在 [mid+1, high] 之间
                    low = mid + 1;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
