package com.algorithm.a1datastructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的LRU缓存.
 * 1. 空间复杂度为o(n)
 * 2. 时间复杂度为o(n)
 * 3. 不支持null缓存
 * <p>
 * 参考: https://github.com/wangzheng0822/algo/blob/master/java/06_linkedlist/LRUBasedArray.java
 *
 * @author fuwb
 * @date 2020-11-13
 */
public class LRUBasedArray<T> {
    /**
     * 默认容量
     */
    private static int DEFAUTL_CAPACITY = (1 << 3);
    /**
     * 数组容量
     */
    private int capacity;
    /**
     * 数组大小
     */
    private int count;

    /**
     * 对象数组.
     */
    private T[] value;

    /**
     * 辅助快速查找对象。
     */
    private Map<Object, Integer> arrayHolder;

    public LRUBasedArray() {
        this(DEFAUTL_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[])new Object[capacity];
        arrayHolder =  new HashMap<>(capacity);
        count = 0;
    }

    /**
     * 访问缓存中一个值 offer
     * @param object
     */
    public void offer(T object ) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }

        // 缓存中是否存在
        final Integer i = arrayHolder.get(object);
        if (i == null) {
            // 不存在时，移动数据，空出头部，存储新元素到头部
            if (isFull()) {
                // 数组已满，踢出末尾元素 加入新元素
                removeAndCache(object);
            } else {
                // 加入新元素
                cache(object);
            }
        } else {
            // 存在时把原对象移动数组头部
            update(i);
        }
    }


    /**
     * 缓存新元素.
     * @param object
     */
    private void cache(T object) {
        // 数组右移
        rightShift(count);
        // 新元素存入头部
        value[0] = object;
        // 新元素存入arrayHolder
        arrayHolder.put(object, 0);
        // 数组大小加1
        count++;
    }


    /**
     * 数组已满，踢出末尾元素 加入新元素.
     * @param object
     */
    private void removeAndCache(T object) {
        // 尾部元素
        final T key = value[--count];
        // 从arrayHolder中移除
        arrayHolder.remove(key);
        // 存储新元素
        cache(object);
    }

    /**
     * 更新已存在元素的位置.
     * @param index
     */
    private void update(int index) {
        // 获取元素
        final T key = value[index];
        // 从head开始右移数组到index
        rightShift(index);
        // 存储新元素
        value[0] = key;
        arrayHolder.put(key, 0);
    }

    /**
     * 数据右移一位.
     * @param end 右移结束位置
     */
    private void rightShift(int end) {
        for (int i = end-1; i >= 0; i--) {
            // 数组移动
            value[i+1] = value[i];
            // arrayHolder 更新索引
            arrayHolder.put(value[i] , i+1);
        }
    }


    private boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : value) {
            sb.append(t).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(1 << 3);
    }


}


