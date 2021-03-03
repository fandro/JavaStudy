package com.algorithm.$1_datastructure.$1_array;

/**
 * 泛型数组.
 *
 * @author fuwb
 * @since 2020-11-05
 */
public class GenericArray<T> {
    private int size;
    private T[] data;

    public GenericArray(int capactiy) {
        this.size = 0;
        data = (T[]) new Object[capactiy];
    }

    public GenericArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int count() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加元素
    public void add(int index, T element) {
        // 各种情况判断
        if (index < 0) {
            return;
        }

        // index 大于 capacity 时，2倍扩容
        if (index >= getCapacity()) {
            int newCapacity = index < (2 * getCapacity()) ? 2 * getCapacity() : index + 1;
            resize(newCapacity);
        }

        // index < size 时数据向后迁移
        if (index < size) {
            moveBack(index+1);
        }

        // 添加 e
        data[index] = element;
        // size加一
        size++;
    }


    // 扩容
    private void resize(int n) {
        // 新建数组
        T[] newData = (T[])new Object[n];

        // 复制数据
        for (int i = 0; i < getCapacity(); i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 添加头元素
    public void addFirst(T e) {
        if (size == getCapacity()) {
            resize( 2 * size);
        }
        moveBack(0);
        data[0] = e;
    }

    // 添加尾元素
    public void addLast(T e) {
        data[size] = e;
    }

    public T get(int i) {
        if (i < 0 || i > getCapacity()) {
            return null;
        }

        return data[i];
    }

    // 删除元素
    public T delete(int i) {
        // 条件判断
        // 已经越界
        if (i < 0 && i >= getCapacity()) {
            return null;
        }

        // 取出数据
        T datum = data[i];
        // 迁移数据
        moveFront(i);

        return datum;
    }


    public T deleteFirst() {
        final T datum = data[0];
        // 迁移数据
        moveFront(0);
        return datum;
    }

    public T deleteLast() {
        final T datum = data[size - 1];
        data[size - 1] = null;
        return datum;
    }

    public int find(T e) {
        for (int i = 0; i < getCapacity(); i++) {
            final T datum = data[i];
            if (datum != null && datum.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 是否包含
    public boolean contains(T e) {
        final int i = find(e);
        return i >= 0;
    }

    // 向后移动数据
    private void moveBack(int i) {
        for (int n = getCapacity()-2 ; n >= i; n--) {
            data[n+1] = data[n];
        }
    }

    // 向前移动数据
    private void moveFront(int i) {
        for (int n = i; n < getCapacity(); n++) {
            if (n == getCapacity() - 1) {
                data[n] = null;
            } else {
                data[n] = data[n+1];
            }
        }
    }
}
