package com.algorithm.$2_sorting;

/**
 * 桶排序.
 *
 * 思路：首先把数据放到有序的桶中，然后对桶中数据使用快排进行排序，最后按顺序取出桶中数据。
 *
 * 具体步骤：
 *  确定数据范围(最小值，最大值)
 *  确定桶的数量，每个桶存放数据范围
 *  根据桶范围和有序性，把数据分配到桶中
 *  桶中数据利用快速排序算法进行排序
 *  依次取出有序桶中的数据，数据即为有序
 *
 * 复杂度：
 *  空间复杂度： O(n)
 *  时间复杂度： 最好、最坏、平均都是 O(n)
 *
 * @author fuwb
 * @date 2021-02-07
 */
public class S05BucketSort {

    public void bucketSort(int[] array, int bucketSize) {
        if (bucketSize < 2) {
            return ;
        }

        // ---- 1. 确定数据范围(最小值，最大值) ----
        int minValue = array[0];
        int maxValue = array[1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // ---- 2. 确定桶的数量，每个桶存放数据范围 ----

        // 例如，数据范围：1-100, bucketSize(桶内数值范围) = 20, bucketCount(桶数量) = 5
        // 桶数量, int相除后会取整，最后剩余的放到一个桶中，所以需要加1
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        // 用二维数组表示n个桶和每个桶中的数据，bucketSize只是初始值，满时需要扩容
        int[][] bucketArray = new int[bucketCount][bucketSize];
        // 记录每个桶的当前索引值，初始值都为0
        int[] bucketDataIndex = new int[bucketCount];


        // ---- 3. 根据桶范围和有序性，把数据分配到桶中 ----
        for (int i = 0; i < array.length; i++) {
            // 计算所属桶的索引：与最小值的差值除以每个桶的数值范围
            int bucketIndex = (array[i] - minValue) / bucketSize;

            // 桶满时进行扩容, 桶的索引值等于桶的容量时表桶满
            if (bucketDataIndex[bucketIndex] == bucketArray[bucketIndex].length) {
                ensureCapacity(bucketArray, bucketIndex);
            }

            // 桶中的索引值递增
            int j = bucketDataIndex[bucketIndex]++;
            // 数据放入同中
            bucketArray[bucketIndex][j] = array[i];
        }


        // ---- 4. 桶中数据利用快速排序算法进行排序 ----
        // 新数组的索引
        int k = 0;
        // 快速排序
        S04QuickSort quickSort = new S04QuickSort();
        // 第一层是桶的维度进行循环
        for (int i = 0; i < bucketArray.length; i++) {
            // 桶中索引值为0时表示没有数据
            if (bucketDataIndex[i] == 0) {
                continue;
            }
            // 对桶内数据排序
            int[] bucketDataArray = bucketArray[i];
            quickSort.quickSort(bucketDataArray);

            // 取出桶中元素
            for (int j = 0; j < bucketDataArray.length; j++) {
                // 剔除0，0表示空元素
                if (bucketArray[i][j] == 0) {
                    continue;
                }
                System.out.println("开始 k="+k);
                array[k++] = bucketArray[i][j];
                System.out.println("结束 k="+k);
            }
        }
        // 依次取出有序桶中的数据，数据即为有序

        // 快排

    }

    /**
     * 桶内数据扩容.
     * @param bucketArray 所有桶
     * @param bucketIndex 桶所在数组的索引
     */
    private void ensureCapacity(int[][] bucketArray, int bucketIndex) {
        // 原桶中数据
        int[] tempArr = bucketArray[bucketIndex];
        // 新桶的扩容为原来的2倍
        int[] newArr = new int[tempArr.length * 2];
        // 更改初始值，便于在取数据时剔除这些未使用的值
        //for (int i = 0; i < newArr.length; i++) {
        //    newArr[i] = -1;
        //}

        for (int i = 0; i < tempArr.length; i++) {
            newArr[i] = tempArr[i];
        }
        bucketArray[bucketIndex]= newArr;
    }

}
