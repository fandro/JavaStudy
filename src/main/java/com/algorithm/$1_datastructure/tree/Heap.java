package com.algorithm.$1_datastructure.tree;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * 堆.
 *
 * @author fuwb
 * @since 2021-03-02
 */
public class Heap {
    // 存储堆的数组
    int[] arr;
    // 堆可以存储的最大数据个数
    int n;
    // 堆中已经存储的数据个数
    int count;

    /**
     * 插入元素.
     * @param data
     */
    public void insert(int data) {
        // 堆已经满
        if (count >= n) {
            return;
        }

        // 计数加1
        count++;
        int i = count;
        // 比较并交互
        while (arr[i/2] >0  && arr[i] > arr[i/2]) {
            // 交互下标为i和i/2的数据
            swap(arr,i,i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶元素.
     */
    public void removeMax() {
        // 堆中没有数据
        if (count == 0) {
            return;
        }
        count--;
        // 把元素放到数组末尾，然后再把元素放到堆顶
        arr[1] = arr[count];
        // 进行堆化
        heapify(arr,n, count);
    }

    private void buildHeap(int[] arr, int n) {
        // 对下标从 n/2 开始到 1 的数据进行堆化，下标是 n + 1 到 n 的节点是叶子节点，我们不需要堆化。
        // 实际上，对于完全二叉树来说，下标从 n/2 + 1 到 n 的节点都是叶子节点。
        for (int i = n/2; i >= 1; i--) {
            heapify(arr, n, i);
        }
    }

    /**
     * 堆排序
     * @param arr 数组
     * @param n 数组大小
     */
    public void sort(int[] arr, int n) {
        buildHeap(arr, n);
        int k = n;
        while (k > 1) {
            swap(arr, 1, k);
            k--;
            heapify(arr, k, 1);
        }
    }

    /**
     * 大顶堆自上而下堆化
     * @param arr 数组
     * @param n 堆的最大下标
     * @param i 当前节点下标
     */
    private void heapify(int[] arr, int n, int i) {
        // 大顶堆自上而下堆化
        while (true) {
            int maxPos = i;
            // 如果不是叶子节点 且i节点值小于左子节点的值，i和maxPos进行互换
            if (i*2 <= n && arr[i] < arr[i*2]) {
                // maxPos位置下移到左子节点
                maxPos = i * 2;
            }
            // 如果不是叶子节点 且i节点值小于右子节点的值, 则i和maxPos进行互换
            if (i*2+1 <= n && arr[maxPos] < arr[i*2+1]) {
                // maxPos位置下移到右子节点
                maxPos = i*2+1;
            }
            // 没有左右子节点，则跳出
            if (maxPos == i) {
                break;
            }

            // i和maxPos 进行互换
            swap(arr, i, maxPos);
            // maxPos变为i，开始下一轮比较
            i = maxPos;
        }

    }
}
