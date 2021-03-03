package com.algorithm.$1_datastructure.$2_linkedlist.singlylinked;

import com.algorithm.$1_datastructure.$2_linkedlist.LinkedList;
import com.algorithm.$1_datastructure.$2_linkedlist.Node;

/**
 * 单链表.
 *
 * @author fuwb
 * @since 2020-11-03
 */
public class SinglyLinkedList<E> implements LinkedList<E> {

    /**
     * 头结点
     */
    private Node<E> head;
    /**
     * 尾结点
     */
    private Node<E> tail;

    /**
     * 链表大小
     */
    private int size;

    @Override
    public Node addElement(E o) {
        Node node = new Node(o);
        // 判断是否有头结点和尾结点，如果没有则新建
        if (head == null && tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            // 在尾部结点后添加新结点，新结点变为尾部结点
            this.tail.next = node;
            this.tail = node;
        }
        size++;
        return node;
    }

    @Override
    public Node insertToHead(E o) {
        Node node = new Node(o);
        if (head != null) {
            node.next = head;
        }
        head = node;
        size++;
        return node;
    }

    @Override
    public Node insertTail(E o) {
        Node node = new Node(o);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return node;
    }

    @Override
    public void insertAfter(Node e, Node newNode) {
        if (e == null) {
            return;
        }

        newNode.next = e.getNext();
        e.next = newNode;
    }

    @Override
    public void insertBefore(Node e, Node newNode) {
        if (e == null) {
            return;
        }

        if (e == head) {
            newNode.next = head;
        }

        Node pre = head;
        while ( pre != null && pre.getNext() != e ) {
            pre = pre.getNext();
        }

        if (pre == null) {
            return;
        }

        newNode.next = e;
        pre.next = newNode;
    }

    @Override
    public Node deleteByNode(E e) {
        // 查找前驱元素 后续
        if (head == null) {
            return null;
        }

        Node preNode = null;
        Node curNode = head;
        do {
            if (e != null && e.equals(curNode.getElement())) {
                preNode.next = curNode.next;
                size--;
                return curNode;
            }
            preNode = curNode;
            curNode = curNode.getNext();
        } while (curNode != null);

        return null;
    }

    @Override
    public Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node oldHead = head;
        head = head.getNext();
        oldHead.next = null;
        size--;
        return oldHead;
    }

    @Override
    public Node removeLast() {
        // 查找前驱元素 后续
        if (head == null || tail == null) {
            return null;
        }

        if (head == tail) {
            Node retNode = tail;
            head = null;
            tail = null;
            size--;
            return retNode;
        }

        Node curNode = head;
        do {
            if (tail.equals(curNode.getNext())) {
                curNode.next = null;
                tail = curNode;
                size--;
                return curNode;
            }
            curNode = curNode.next;
        } while (curNode != null);

        return null;
    }

    @Override
    public Node findElement(E e) {
        if (head == null) {
            return null;
        }

        Node curNode = head;
        do {
            if (e != null && e.equals(curNode.getElement())) {
                return curNode;
            }
            curNode = curNode.next;
        } while (curNode != null);

        return null;
    }

    @Override
    public Node findByIndex(int i) {
        int index = 0;
        Node p = head;
        while (p != null && index != i) {
            p = p.next;
            index++;
        }

        return p;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public Node getTail() {
        return tail;
    }

    /**
     * 判断是否有回文.
     * @return
     */
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            System.out.println("开始寻找中间结点");
            // 通过快慢指针寻找中间结点
            Node slow = head;
            Node fast = head;
            if (slow.next == null) {
                System.out.println("只有一个元素");
                return true;
            }

            while (slow.next !=null && fast.next != null && fast.next.next != null) {
                // 慢指针每次走一步
                slow = slow.next;
                // 快指针每次走两步
                fast = fast.next.next;
            }
            // 慢指针为中间结点
            System.out.println("中间结点：" + slow.getElement());
            Node leftLink = null;
            Node rightLink = null;
            if (fast.next == null) {
                // fast 结点位置是 1-3-5-7
                System.out.println("结点数为奇数");
                // 中间结点下一个结点
                rightLink = slow.next;
                // 中间结点左侧进行反转
                leftLink = inverstLinkedList(slow).next;
                System.out.println("右侧第一个结点"+ rightLink.getElement());
                System.out.println("左侧第一个结点"+ leftLink.getElement());
            } else {
                // fast.next结点位置是 2-4-6-8
                // 结点为偶数，slow和slow.next 均为中点
                System.out.println("结点数为偶数");
                rightLink = slow.next;
                leftLink = inverstLinkedList(slow);
            }
            return TFResult(rightLink, leftLink);
        }
    }

    /**
     * 判断两个链表是否相同.
     * @param left
     * @param right
     * @return
     */
    public boolean TFResult(Node left, Node right) {
        boolean flag = true;
        Node l = left;
        Node r = right;

        while (l != null && r != null) {
            if (l.getElement() == r.getElement()) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }


    /**
     * 带头结点(哨兵结点)的链表反转，结点p右侧进行反转.
     * @param p
     * @return
     */
    public Node inverstLinkedList_head(Node p) {
        // 新建一个头结点(哨兵结点),不参与反转
        Node head = new Node("newHead");
        // 头结点指向结点p
        head.next = p;

        // p的next结点定义为cur
        Node cur = p.next;
        // 删除p指针
        p.next = null;
        Node next = null;
        // 以p点为头结点开始反转
        while (cur != null) {
            // cur的next结点定义为next
            next = cur.next;
            // cur 指向head后的第一个结点
            cur.next = head.next;
            // cur变为head后的第一个结点
            head.next =cur;

            // next变为cur
            cur = next;
        }

        // 返回头结点，从头结点后面就是一个反转后的列表
        return head;
    }

    /**
     * 无头结点的链表反转, 结点p左侧进行反转。
     * @param p
     * @return
     */
    public Node inverstLinkedList(Node p) {
        // 前驱结点
        Node pre = null;
        // 当前结点
        Node r = head;
        // 后续结点
        Node next = null;

        while (r != p) {
            // 获取后继结点
            next = r.next;
            // 当前结点指向pre
            r.next = pre;

            // 当前结点变为前驱结点pre
            pre = r;
            // 后继结点变为当前结点
            r = next;
        }

        // 当前结点变为前驱结点pre
        r.next = pre;

        return p;
    }


    void printAllNode() {
        Node p = head;
        while (p != null) {
            System.out.print(p.getElement() + " ");
            p = p.next;
        }
        System.out.println();
    }


}
