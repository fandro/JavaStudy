package algorithm.sorting;

import java.util.Arrays;

/**
 * 冒泡排序.
 * 思路：
 * 1. 排序过程分为2个区：未排序区和已排序区。
 * 2. 初始化状态时整个数组是未排序区
 * 3. 对数组进行n轮冒泡(比较)，每轮过后一个元素从未排序区移动排序区, 未排序区边界值减少1，已排序区边界值新增1
 * 4. 如果一轮过后没有数据发生交换，正在未排序区的数据已经是有序了，此时直接退出循环
 * @author fuwb
 * @date 2020-08-25
 */
public class Sort01BubbleSort {
    public static void main(String[] args) {
        //int[] a = {9,8,5,8,4,7,2,6};
        // 前3个元素有序
        int[] a = {3,4,5,9,8,7,6};
        bubbleSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a, int n) {

        // 第一层循环：表示需要进行n轮冒泡
        for (int i = 0; i < n; i++) {
            // 第二层循环：表示对未排序区进行比较交互
            // j表示未排序边界值，每一轮冒泡后排序区边界加1，未排序区边界减1
            // 未排序区是否已经有序
            boolean isSorted = true;
            int k = n - 1 - i ;
            for (int j = 0; j < k; j++) {
                // a1大于a2时 交互位置
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    isSorted = false;
                }
            }
            // 未排序区已经有序,则直接退出
            if (isSorted) {
                break;
            }
        }
    }
}
