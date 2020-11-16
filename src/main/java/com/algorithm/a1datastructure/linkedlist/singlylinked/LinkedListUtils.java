package com.algorithm.a1datastructure.linkedlist.singlylinked;

import com.algorithm.a1datastructure.linkedlist.Node;

/**
 * 1. 单链表反转
 * 2. 检测环
 * 3. 两个链表合并
 * 4. 删除链表倒数第n个结点
 * 5. 求链表中间结点
 *
 * @author fuwb
 * @date 2020-11-11
 */
public class LinkedListUtils {


    /**
     * 单链表反转.
     * @param list
     * @return
     */
    public static Node reverse(Node list) {
        Node pre = null;
        Node cur = list;
        Node next = null;
        if (list == null) {
            return null;
        }

        while (cur != null) {
            // 获取后续结点
            next = cur.next;
            // 当前结点cur指针指向pre
            cur.next = pre;
            // 当前结点cur变为pre
            pre = cur;
            // next结点变为cur结点
            cur = next;
        }
        return pre;
    }

    /**
     * 检测环.
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list) {
        // 通过快慢指针是否重合来检查环
        if (list == null) {
            return false;
        }
        Node slow = list;
        Node fast = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * 两个链表合并
     * @param list1
     * @param list2
     * @return
     */
    public static Node mergeTwoList(Node<Integer> list1, Node<Integer> list2){
        // 利用哨兵结点指向头结点，方便取出头结点
        Node sentinel = new Node(0);
        // last作为合并后的最后一个结点
        Node last = sentinel;

        while (list1 !=null && list2 != null) {
            if (list1.getElement() < list2.getElement()) {
                // 尾结点指向list1
                last.next = list1;
                // list1结点后移
                list1 = list1.next;
            } else {
                // 尾结点指向list1
                last.next = list2;
                // list1结点后移
                list2 = list2.next;
            }
            // 尾结点后移
            last = last.next;
        }

        // 如果其中一个有剩余元素则附加到尾部结点
        if (list1 != null) { last.next = list1; }
        if (list2 != null) { last.next = list2; }

        // 返回头结点
        return sentinel.next;
    }

    /**
     * 删除链表倒数第n个结点
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    /**
     * 求链表中间结点
     * @param list
     * @return
     */
    public static Node findMiddleNode(Node list) {

        // 通过快慢指针,快指针走的终点，慢指针走到中点。
        if (list == null) {
            return null;
        }

        Node slow = list;
        Node fast = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null) {
        }
        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.getElement() + " ");
            p = p.next;
        }
        System.out.println();
    }
}
