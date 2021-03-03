package com.algorithm.$1_datastructure.$3_queue;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-11-17
 */
public class CircularQueueBaseOnArray {

    private String[] array;
    /**
     * 数组容量
     */
    private int size = 0;
    /**
     * 队头下标
     */
    private int head = 0;
    /**
     * 队尾下标
     */
    private int tail = 0;

    public CircularQueueBaseOnArray(int size) {
        this.size = size;
        array = new String[size];
    }

    /**
     * 入队列.
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 如果队列满，则入队失败
        if ((tail + 1)%size == head) {
            return false;
        }

        // 如果到达队尾则转移到队首
        if (tail == size) {
            tail = 0;
        }

        array[tail] = item;
        // (tail + 1) % size 这个算法会在队列末尾空出一个位置无法存储元素
        // 因为 tail = size - 1 时，下一步就跳到的下标是0
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 出队列
     * @return
     */
    public String dequeue() {
        // 队列为空
        if (tail == head) {
            return null;
        }
        String item = array[head];
        array[head] = null;
        head = (head + 1) % size;
        return item;
    }

    public String findByIndex(int i) {
        return array[i];
    }
}
