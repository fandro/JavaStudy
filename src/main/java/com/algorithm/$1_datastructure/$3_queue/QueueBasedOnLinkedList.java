package com.algorithm.$1_datastructure.$3_queue;

/**
 * 基于链表实现的队列.
 *
 * @author fuwb
 * @date 2020-11-17
 */
public class QueueBasedOnLinkedList {

    private Node head;
    private Node tail;


    public boolean enqueue(String item) {
        Node node = new Node(item);
        if (tail == null) {
            this.tail = node;
            this.head = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        return true;
    }

    public String dequeue(){
        if (head == null) {
            return null;
        }
        Node node = this.head;
        head = head.next;
        node.next=null;
        if (head == null) {
            tail = null;
        }
        return node.getData();
    }

    public String findByIndex(int i) {
        if (head == null) {
            return null;
        }
        int n = 0;
        Node p = head;
        while (p != null) {
            if (i == n) {
                return p.getData();
            }
            n++;
            p = p.next;
        }

        return null;
    }

    class Node {
        private String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
