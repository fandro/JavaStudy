package com.algorithm.$2_sorting;

/**
 * 归并排序.
 * 总体思路：
 *    把数组分成前后两部分，前后两部分再分解为两部分，直到分解为两个单独的元素，然后开始从底向上开排序并合并，最后合并成一个有序数组.
 *    处理思想：分治思想
 *    编程技巧：递归
 * 具体步骤：
 * 1. 把数组分解为两数组
 * 2. 申请一个临时数组用于存放合并后的数据，临时的数组大小为两数组之和
 * 3. 设定两个指针，分别指向两个数据起始位置
 * 4. 根据两个指针分别从两个数组取出数据进行比较，较小者放入临时数组，较小者的指针移动到下一位(下标加一)
 * 5. 重复步骤3直到某一个数组指针到达末尾
 * 6. 根据指针判断数组是否有剩余元素，把剩余元素放入临时数组，数组合并完成
 * 7. 从步骤1递归调用，完成数组分解、排序、合并。
 *
 * 复杂度：
 *  空间复杂度： O(n)
 *  时间复杂度： 最好、最坏、平均都是 O(nlogn)
 *
 * @author fuwb
 * @date 2020-11-23
 */
public class S03MergeSort {

    public void mergeSort(int[] array) {
        // 计算数组中间元素
        doMergeSort(array, 0, array.length-1);
    }

    private void doMergeSort(int[] array, int start, int end) {

        // 终止条件
        if (start >= end) {
            return;
        }

        // 计算数组中间元素，防止两数相加后数字越界，公式进行变形
        // int mid = (start + end)/2 = (end - start + 2*start)/2 = (end - start)/2 + start
        int mid = (end - start)/2 + start;

        // 数组分为两部分，开始递归
        doMergeSort(array, start, mid);
        doMergeSort(array, mid + 1, end );

        // 合并过程,将array[start...mid]和array[mid+1...end]合并
        //mergeArray(array, start, mid, end);
        mergeBySentry(array, start, mid, end);
    }

    private void mergeArray(int[] array, int start, int mid, int end) {
        // 分解的两个数组A和B

        // 新建一个临时数组,大小等于A和B数组的长度
        int[] tempArray = new int[end - start +1];
        // 同时从A和B开始取出数据进行对比，较小者放入临时数组, 如果A或B有剩余，则直接加入临时数组
        // 数组A起始索引
        int i = start;
        // 数组B起始索引
        int j = mid+1;
        // 临时数组起始索引
        int tempIndex = 0;

        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                // 取出数组A中元素放入临时数组
                tempArray[tempIndex++] = array[i++];
            } else {
                // 取出数组B中元素放入临时数组
                tempArray[tempIndex++] = array[j++];
            }
        }

        // 如果A或B有剩余，则直接加入临时数组（可以使用哨兵解决这一步）
        // i <= mid 表示数组A中有剩余, 否则(j <= end)表示数组B中有剩余
        int tempStart = (i <= mid) ? i : j ;
        int tempEnd   = (i <= mid) ? mid : end;

        while (tempStart <= tempEnd) {
            tempArray[tempIndex++] = array[tempStart++];
        }

        // 把临时数组中数据拷贝会原数组
        for (int n = 0; n <= (end - start) ; n++) {
            array[start + n] = tempArray[n];
        }

    }

    /**
     * 合并,哨兵辅助。
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private void mergeBySentry(int[] array, int start, int mid, int end) {
        // 预留一位存储哨兵
        int[] leftArr = new int[mid - start +2];
        int[] rightArr = new int[end - mid + 1];

        // 取出数据放到数组中
        for (int i = 0; i <= (mid - start) ; i++) {
            leftArr[i] = array[start+i];
        }
        // 左边数组添加哨兵
        leftArr[mid-start+1] = Integer.MAX_VALUE;

        for (int i = 0; i < end - mid; i++) {
            rightArr[i] = array[mid+1+i];
        }
        // 右边数组添加哨兵
        rightArr[end - mid] = Integer.MAX_VALUE;

        // 合并两个数组的数据到array中
        // leftArr下标
        int i = 0;
        // rightArr下标
        int j = 0;
        int k = start;
        while (k <= end) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] < rightArr[j]) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }

    }

}
