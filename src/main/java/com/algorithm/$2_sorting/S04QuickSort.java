package com.algorithm.$2_sorting;

/**
 * 快速排序.
 *
 * 思路：从数组中找个元素做pivot(轴)进行分区操作(小于pivot的放数组左边，大于pivot的放数组右边)，再对数组左右进行一次分区操作，如此递归，直到排序完成
 *
 * 具体步骤：
 * 快排分区方法1：相向指针法
 * 1. 选择尾部元素做为基准值
 * 2. 新建两个指针：左指针和右指针
 * 3. 移动指针：左指针从左向右移动，遇到大于基准值时移动停止，此时下标记为A；右指针从有向左移动，遇到小于基准值时移动停止，此时下标记为B；
 * 4. 交互数据：交互小标A和小标B的数据
 * 5. 重复3-4步骤，直到左右指针相同时结束
 *
 * 快排分区方法2：同向指针法
 * 1. 选择尾部元素做为基准值
 * 2. 新建两个指针：正常指针和慢指针
 * 3. 移动指针：两指针同时从第一个元素开始移动，正常指针每次移动一步，慢指针每次移动一步，遇到大于基准时停止移动；
 * 4. 交换数据：符合互换数据条件时进行数据互换，互换数据条件：两指针不相同(慢指针停在了大值上)并且正常指针指向值小于基准
 * 5. 重复3-4步骤，直到左右指针相同时结束
 * 6. 交换基准元素与慢指针元素
 *
 * 复杂度：
 *  空间复杂度： O(n)
 *  时间复杂度： 最好、最坏、平均都是 O(nlogn)
 *
 * @author fuwb
 * @date 2020-11-24
 */
public class S04QuickSort {

    public void quickSort(int[] array) {
        doQuickSort(array, 0, array.length-1);
    }

    private void doQuickSort(int[] array, int start, int end) {
        // 终止条件
        if (start >= end) {
            return;
        }

        // 进行分区,返回基准下标,根据两个指针移动方向的不同分为两种分区方法
        int p = partitionByTwoSameDirectionPoint(array, start, end);
        //int p = partitionByTwoOppositeDirectionPoint(array, start, end);

        // 对左右两部分进行操作
        doQuickSort(array, start, p-1);
        doQuickSort(array,p+1, end);
    }

    /**
     * 找个基准值，依次比较，分为大小两个区。
     * 使用两个方向相对的指针，找到符合条件数据时 两个指针数据进行互换
     * @param array
     * @param start
     * @param end
     * @return 分区基准的下标值
     */
    private int partitionByTwoOppositeDirectionPoint(int[] array, int start, int end) {
        // 用末尾元素作为基准
        int pivot = array[end];
        // 定义左右两个指针，左指针从左向右移动,遇到大于基准的元素则停止，开始从右向左移动右指针,遇到小于基准的元素则停止
        int leftIndex = start;
        int rightIndex = end-1;
        boolean changeFlag = false;
        for (int i = start; i < end; i++) {
            // 记录左指针当前位置
            leftIndex = i;
            // 遇到大于基准的元素则停止,开始从右向左移动右指针
            if (array[i] > pivot ) {
                changeFlag = true;
                for (int j = rightIndex; j >= leftIndex ; j--) {
                    // 记录右指针当前位置
                    rightIndex = j;
                    // 遇到小于基准的元素则停止
                    if (array[j] < pivot) {
                        // 交互元素
                        int temp = array[leftIndex];
                        array[leftIndex] = array[rightIndex];
                        array[rightIndex] = temp;
                        break;
                    }
                }
            }

            // 左右指针相同时终止
            if (leftIndex >= rightIndex ) {
                break;
            }
        }

        if (changeFlag) {
            // 基准元素换入中间区域
            array[end] = array[leftIndex];
            array[leftIndex] = pivot;
            return leftIndex;
        } else {
            return end;
        }
    }


    /**
     * 使用两个方向相同的指针(A和B)，小于基准时AB同时移动，大于基准时A移动，B不移动，然后A和B元素进行互换。
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static int partitionByTwoSameDirectionPoint(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        for(int j = start; j < end; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;

        System.out.println("i=" + i);
        return i;
    }


    private static void quickSort(int[] a, int head, int tail) {

        int low = head;
        int high = tail;
        int pivot = a[low];
        if (low < high) {

            while (low<high) {
                while (low < high && pivot <= a[high]) {
                    high--;
                }
                a[low] = a[high];
                while (low < high && pivot >= a[low]) {
                    low++;
                }
                a[high]=a[low];
            }
            a[low] = pivot;

            if(low>head+1) { quickSort(a,head,low-1);}
            if(high<tail-1) { quickSort(a,high+1,tail);}
        }

    }

/*
=================== 指针相向法 partitionByTwoOppositeDirectionPoint====================================
3 5 8 1 2 9 4 7 6  // 选取6
3 5 8> 1 2 9 4 7 6  // 从左开始依次与6比较，找到大于6的8时后停止 leftIndex=2
3 5 8 1 2 9 4< 7 6  // 从右开始依次与6比较，找到小于6的4时后停止 rightIndex=6
3 5 4> 1 2 9 8< 7 6  // 8和4位置互换
3 5 4 1 2 9> 8< 7 6  // 左边从leftIndex=2开始依次与6比较，找到大于6的9时后停止 leftIndex=5
3 5 4 1 2 9>< 8 7 6  // 右边从rightIndex=6开始依次与6比较，左一位后rightIndex=5，此时leftIndex = rightIndex，则停止,leftIndex = rightIndex=5对应的元素9就是个分界值，然后把9与6互换位置
3 5 4 1 2 6>< 8 7 9 // 此时完成了分区

=================== 指针同向法：partitionByTwoSameDirectionPoint====================================
3 5 8 1 2 9 4 7 6    // 选取末尾元素6做为基准
3*> 5 8 1 2 9 4 7 6  // 两指针为慢指针(*)和正常指针(>)，两指针同时从第一个元素开始移动
3 5 8* 1> 2 9 4 7 6  // 慢指针(*)遇到大于基准的值时停止，正常指针(>)每次移动一步，
3 5 1* 8> 2 9 4 7 6  // 如果慢指针(*)和正常指针(>)不相同，并且正常指针指向值小于基准，此时慢指针(*)指向值大于基准，两指针对应值进行互换
3 5 1 8* 2> 9 4 7 6  // 两指针继续向前移动，此时符合交换条件
3 5 1 2* 8> 9 4 7 6  // 符合交互条件，进行数据互换
3 5 1 2 8* 9> 4 7 6  // 慢指针不动，正常指针移动
3 5 1 2 8* 9 4> 7 6  // 慢指针不动，正常指针移动，符合交换条件，进行数据互换
3 5 1 2 4* 9 8> 7 6  // 交互数据
3 5 1 2 4  9* 8 7> 6  // 正常移动指针到终点，移动结束
3 5 1 2 4  6* 8 7> 9  // 基准与慢指针交互位置*/
}
