package com.algorithm.a1datastructure.linkedlist;

/**
 *
 * 基于链表的LRU算法.
 * 参考: https://github.com/wangzheng0822/algo/blob/master/java/06_linkedlist/LRUBaseLinkedList.java
 * @author fuwb
 * @date 2020-11-13
 */
public class LRUBaseLinkedList<T> {
    private final static Integer DEFAULT_CAPACITY = 8;
    /**
     * 链表长度
     */
    private int length;
    /**
     * 头结点
     */
    private Node head;

    /**
     * 链表容量，链表需要控制的长度.
     */
    private int capacity;

    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.head = new Node("0");
        this.length = 0;
    }

    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.length = 0;
    }

    /**
     * 添加结点
     * @param data
     */
    public void add(T data) {
        // 查找元素的前序结点
        Node preNode = findPreNode(data);
        if (preNode != null) {
            // 元素已经存在时，删除原元素，头部新增元素
            deleteElement(preNode);
        } else if (this.length >= this.capacity) {
            // 容量已经满,删除尾部元素
            deleteTail();
        }
        // 头部插入新元素
        insertToHead(data);
    }

    private void insertToHead(T data) {

        // 插入到head后面
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
        length++;
    }

    private void deleteTail() {
        Node p = head;

        while (p.next.next != null) {
            p = p.next;
        }
        // last 是最后一个元素
        Node last = p.next;
        // 倒数第二个指针清空
        p.next = null;
        last = null;

        length--;
    }

    /**
     * 删除原元素.
     * @param preNode
     */
    private void deleteElement(Node preNode) {
        Node node = preNode.next;
        if (preNode != null && preNode.next != null) {
            preNode.next = node.next;
        }
        node = null;
        length--;
    }

    /**
     * 查找元素的前序结点
     * @param data
     * @return
     */
    private Node findPreNode(T data) {
        if (data == null) {
            return null;
        }
        Node p = head;

        while (p != null && p.next != null) {
            Node next = p.next;
            if (data.equals(next.getElement())) {
                return p;
            }
            p = next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node node = head.getNext();
        while (node != null) {
            sb.append(node.getElement() + ",");
            node = node.getNext();
        }
        return sb.toString();
    }
}
