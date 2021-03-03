package com.algorithm.$1_datastructure.$2_linkedlist;

/**
 * 链表操作接口.
 *
 * @author fuwb
 * @since 2020-11-03
 */
public interface LinkedList<E> {

    /**
     * 新增元素
     * @return Node
     */
    Node addElement(E e);

    /**
     * 新增头元素
     * @return Node
     */
    Node insertToHead(E e);

    /**
     * 新增尾元素
     * @param e
     * @return Node
     */
    Node insertTail(E e);

    /**
     * 在pre结点后插入一个新结点.
     * @param e
     * @param newNode
     */
    void insertAfter(Node e, Node newNode);


    /**
     * 在结点前插入一个新结点.
     * @param e
     * @param newNode
     */
    void insertBefore(Node e, Node newNode);

    /**
     * 删除元素
     * @return Node
     */
    Node deleteByNode(E e);

    /**
     * 删除头元素
     * @return Node
     */
    Node removeFirst();

    /**
     * 删除尾元素
     * @return Node
     */
    Node removeLast();

    /**
     * 查找元素
     * @param e 元素
     * @return Node
     */
    Node findElement(E e);

    /**
     * 通过索引查找元素
     * @param i 元素
     * @return Node
     */
    Node findByIndex(int i);

    /**
     * 判断链表是否为空.
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 链表大小.
     * @return
     */
    int size();

    /**
     * 头结点.
     * @return Node
     */
    Node getHead();

    /**
     * 尾部结点.
     * @return Node
     */
    Node getTail();


}
