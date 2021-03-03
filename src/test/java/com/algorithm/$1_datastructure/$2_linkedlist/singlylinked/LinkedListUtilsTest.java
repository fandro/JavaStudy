package com.algorithm.$1_datastructure.$2_linkedlist.singlylinked;

import com.algorithm.$1_datastructure.$2_linkedlist.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-11-12
 */
class LinkedListUtilsTest {

    SinglyLinkedList<String> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new SinglyLinkedList<>();
        linkedList.addElement("1-Node");
        linkedList.addElement("2-Node");
        linkedList.addElement("3-Node");
        linkedList.addElement("4-Node");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverseTest() {
        final Node reverse = LinkedListUtils.reverse(linkedList.getHead());
        assertEquals("4-Node" ,reverse.getElement());
    }

    @Test
    void checkCircleTest() {
        final Node head = linkedList.findElement("1-Node");
        final Node tail = linkedList.findElement("4-Node");
        tail.next = head;
        final boolean isCircle = LinkedListUtils.checkCircle(head);
        assertTrue(isCircle);
    }

    @Test
    void mergeTwoListTest() {
        Node l11 = new Node(1);
        Node l12 = new Node(4);
        Node l13 = new Node(7);
        l11.next = l12;
        l12.next = l13;


        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(8);
        l21.next = l22;
        l22.next = l23;
        Node node = LinkedListUtils.mergeTwoList(l11, l21);
        LinkedListUtils.printAll(node);
    }

    @Test
    void deleteLastKthTest() {
    }

    @Test
    void findMiddleNodeTest() {
    }

}