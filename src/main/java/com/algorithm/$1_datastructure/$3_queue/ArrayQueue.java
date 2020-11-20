package com.algorithm.$1_datastructure.$3_queue;

/**
 * 基于数组实现的顺序队列.
 * 使用两个指针：头指针和尾指针，头指针出队时
 *
 * @author fuwb
 * @date 2020-11-17
 */
public class ArrayQueue {

    private String[] array;

    private int size;

    /**
     * 头指针，出队时更新.
     */
    private int head;

    /**
     * 尾部指针，入队时更新
     */
    private int tail;

    public ArrayQueue(int size) {
        this.size = size;
        this.array = new String[size];
    }

    /**
     * 入队,使用tail指针.
     * 1.堆满的时，入队失败
     * 1.1频繁出入队，造成数组使用不连续
     * 1.2在入队的时候，集中触发进行数据搬移
     * 2.在末尾插入数据，注意tail指向队尾元素的索引+1
     */
    public boolean enqueue(String item) {
        // 队列已满
        if (tail == size) {
            if (head == 0) {
                // 队列已满
                return false;
            }
            //int n = tail - head;
            // 尾部指针到达边界，需要移动数据
            for (int i = head; i < tail; i++) {
                // 元素迁移
                array[i - head] = array[i];
                // 原元素清空
                array[i] = null;
            }

            // 重置尾指针
            tail = tail - head;
            // 重置头指针
            head = 0;
        }

        array[tail] = item;
        tail++;

        return true;
    }

    /**
     * 出队,使用head指针.
     * 1.队空时，出队失败;2.出队，head索引+1
     */
    public String dequeue() {
        if (tail == head) {
            // 队列为空
            return null;
        }
        String item = array[head];
        // 清空元素
        array[head] = null;
        head++;
        return item;
    }

    public String findByIndex(int index) {
        return array[index];
    }
}
