package com.algorithm.a1datastructure.linkedlist;

/**
 * 链表中的结点.
 *
 * @author fuwb
 * @date 2020-11-03
 */
public class Node<E> {
    /**
     * 数据元素
     */
    private E element;

    /**
     * 后继指针
      */
    private Node<E> next;

    /**
     * 前驱指针
      */
    private Node<E> prev;

    public Node(E data) {
        this.element = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
