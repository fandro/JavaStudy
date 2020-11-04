package com.algorithm.a1datastructure.linkedlist.singlylinked;

import com.algorithm.a1datastructure.linkedlist.LinkedList;
import com.algorithm.a1datastructure.linkedlist.Node;

/**
 * 单链表.
 *
 * @author fuwb
 * @date 2020-11-03
 */
public class SinglyLinkedList<E> implements LinkedList<E> {

    /**
     * 头结点
     */
    private Node head;
    /**
     * 尾结点
     */
    private Node tail;

    /**
     * 链表大小
     */
    private int size;

    @Override
    public void addElement(E o) {

    }

    @Override
    public void addFirst(E o) {

    }

    @Override
    public void addLast(E o) {

    }

    @Override
    public void removeElement() {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public Node queryElement(E e) {
        return null;
    }

    @Override
    public Node first() {
        return null;
    }

    @Override
    public Node last() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

}
