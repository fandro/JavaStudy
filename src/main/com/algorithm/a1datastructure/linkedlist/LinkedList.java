package com.algorithm.a1datastructure.linkedlist;

/**
 * 链表操作接口.
 *
 * @author fuwb
 * @date 2020-11-03
 */
public interface LinkedList<E> {

    /**
     * 新增元素
      */
    void addElement(E e);

    /**
     * 新增头元素
      */
    void addFirst(E e);

    /**
     * 新增尾元素
     * @param e
     */
    void addLast(E e);

    /**
     * 删除元素
      */
    void removeElement();

    /**
     * 删除头元素
     */
    void removeFirst();

    /**
     * 删除尾元素
     */
    void removeLast();
    /**
     * 查找元素
     */
    Node queryElement(E e);

    Node first();
    Node last();
    /**
     * 判断链表是否为空
     */
    boolean isEmpty();

    /**
     * 链表大小.
     * @return
     */
    int size();
}
