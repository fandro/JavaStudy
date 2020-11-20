package com.algorithm.$1_datastructure.stack;

/**
 * 基于链表实现的栈-链表栈.
 * 新加入结点作为头结点
 * @author fuwb
 * @date 2020-11-16
 */
public class LinkedListStack {

    /**
     * 新加入结点作为头结点
     */
    private Node<String> top;
    /**
     * 栈大小
     */
    private int size;

    /**
     * 栈中元素个数
     */
    private int count;

    public LinkedListStack(int size) {
        this.size = size;
        this.count = 0;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(String item){
        if (count == size) {
            return false;
        }
        Node newNode = new Node(item);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        count++;
        return true;
    }

    /**
     * 出栈.
     * @return
     */
    public String pop(){
        if (top == null || count == 0) {
            return null;
        }
        String element = top.getElement();
        // 移动到新top结点，释放原top结点
        Node newTop = top.next;
        top.next = null;
        top = newTop;
        count--;
        return element;
    }

    public int getCount() {
        return count;
    }

    class Node<E> {
        /**
         * 数据元素
         */
        public E element;

        /**
         * 后继指针
         */
        public Node<E> next;

        /**
         * 前驱指针
         */
        public Node<E> prev;

        public Node() {
        }

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
}
