package com.algorithm.$1_datastructure.stack;

/**
 * 基于数组实现栈操作(顺序栈).
 *
 * @author fuwb
 * @date 2020-11-16
 */
public class ArrayStack {
    /**
     * 数组
      */
    private String[] array;
    /**
     * 栈大小
     */
    private int size;
    /**
     * 栈中元素个数
     */
    private int count;

    public ArrayStack(int n) {
        this.size = n;
        this.array = new String[n];
        this.count = 0;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(String item){
        // 栈已经满,返回false
        if (count == size) {
            return false;
        }
        // item放入数组，count数量加1
        array[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈.
     * @return
     */
    public String pop(){
        if (count == 0) {
            return null;
        }
        // 获取数组尾部元素
        String item = array[count-1];
        count--;
        return item;
    }

    public int getCount() {
        return count;
    }
}
