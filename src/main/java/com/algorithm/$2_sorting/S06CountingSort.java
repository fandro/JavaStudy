package com.algorithm.$2_sorting;

/**
 * TODO
 *
 * @author fuwb
 * @date 2021-02-07
 */
public class S06CountingSort {


    public void countingSort(int[] array, int totalSize) {

        if (totalSize <= 1) {
            return;
        }

        // 确定数据范围(最小值，最大值)
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        // 创建有序的桶，每个桶只存储一种相同的值,下标[0,max]
        int[] bucketArray = new int[max + 1];

        // 把数据分配到桶中(计数的数组)，数组下标是数值A，该下标存储的内容是数值A的数量和前面元素数量之和
        // 计算每个值的数量
        for (int i = 0; i < array.length; i++) {
            bucketArray[array[i]]++;
        }

        // 依次累加前面的数量
        for (int i = 1; i < bucketArray.length; i++) {
            bucketArray[i] = bucketArray[i-1] + bucketArray[i];
        }

        // 依次取出有序桶中的数值，数值依次减一就是数据的序号，最后排序成功
        int[] tempArray = new int[totalSize];

        for (int i = totalSize - 1; i >= 0; i--) {
            // array[i]的值就是bucketArray的下标
            int counter = bucketArray[array[i]];
            int index = counter - 1;
            tempArray[index] = array[i];
            bucketArray[array[i]]--;
        }

        // 将结果拷贝到array数组
        for (int i = 0; i < totalSize; i++) {
            array[i] = tempArray[i];
        }

    }

}
