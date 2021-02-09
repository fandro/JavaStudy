package com.algorithm.$2_sorting;

/**
 * 基数排序.
 *
 * @author fuwb
 * @date 2021-02-07
 */
public class S07RadixSort {

    public void radixSort(int[] array) {

        // 整理成相同长度
        // 确定数据范围
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 从各位开始，对数组按'指数'进行排序
        for (int exp = 1; max/exp > 0 ; exp *= 10) {
            countingSort(array, exp);

        }

        // 从高位到低位依次进行比较并排序

        // 所有数据同一位置比较并排序所有数据


    }

    /**
     * 计数排序-对数组按照'某个位数'进行排序
     * @param array
     * @param exp
     */
    private void countingSort(int[] array, int exp) {
        if (array.length <= 1) {
            return;
        }
        // 计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < array.length; i++) {
            c[(array[i] / exp) % 10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        // 临时数组r,存储排序后的结果
        int[] r = new int[array.length];
        for (int i = array.length -1 ; i >= 0; i--) {
            r[c[(array[i] / exp) % 10] -1] = array[i];
            c[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = r[i];
        }

    }
}
