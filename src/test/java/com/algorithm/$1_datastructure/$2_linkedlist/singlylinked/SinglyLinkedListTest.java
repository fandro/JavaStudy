package com.algorithm.$1_datastructure.$2_linkedlist.singlylinked;

import com.algorithm.$1_datastructure.$2_linkedlist.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 单链表。
 *
 * @author fuwb
 * @date 2020-11-03
 */
class SinglyLinkedListTest {

    SinglyLinkedList<String> linkedList;

    @BeforeEach
    public void init () {
        linkedList = new SinglyLinkedList<>();
        linkedList.addElement("1-Node");
        linkedList.addElement("2-Node");
        linkedList.addElement("3-Node");
        linkedList.addElement("4-Node");

    }

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"1-Node", "2-Node" ,"4-Node"})
    @DisplayName("findElementTest 查找元素")
    void findElementTest(String value) {
        final Node node = linkedList.findElement(value);
        assertNotNull(node);
        assertEquals(value, node.getElement());
    }

    @Order(2)
    @DisplayName("添加元素")
    @Test
    void addElementTest() {
        linkedList = new SinglyLinkedList<>();
        final Node firstNode = linkedList.addElement("1-Node");
        Node node = linkedList.findElement("1-Node");
        assertEquals(node, firstNode);
    }

    @DisplayName("添加头元素1")
    @Test
    void addHeadTest_empty() {
        linkedList = new SinglyLinkedList<>();
        final Node node = linkedList.insertToHead("one");
        assertNotNull(node);
        assertEquals(node, linkedList.getHead());
    }

    @DisplayName("添加头元素2")
    @Test
    void addHeadTest_haveData() {
        final Node node = linkedList.insertToHead("one");
        assertNotNull(node);
        assertEquals(node, linkedList.getHead());
        assertEquals("1-Node", linkedList.getHead().getNext().getElement());
    }

    @DisplayName("删除元素")
    @Test
    void removeElementTest() {
        final Node node = linkedList.deleteByNode("3-Node");
        assertNotNull(node);
        final Node preNode = linkedList.findElement("2-Node");
        assertNotNull(preNode);
        assertEquals("4-Node", preNode.getNext().getElement());
    }

    @DisplayName("删除头元素")
    @Test
    void removeFirstTest() {
        final Node node = linkedList.removeFirst();
        assertNotNull(node);
        assertEquals("2-Node", linkedList.getHead().getElement());
    }

    @DisplayName("删除尾元素")
    @Test
    void removeLastTest() {
        final Node node = linkedList.removeLast();
        assertNotNull(node);
        assertEquals("3-Node", linkedList.getTail().getElement());
    }


    @DisplayName("判断是否为空")
    @Test
    void isEmptyTest() {
        assertFalse(linkedList.isEmpty());
        linkedList = new SinglyLinkedList<>();
        assertTrue(linkedList.isEmpty());
    }

    @DisplayName("链表长度")
    @Test
    void sizeTest() {
        assertEquals(4, linkedList.size());
        linkedList.deleteByNode("3-Node");
        assertEquals(3, linkedList.size());
        linkedList.removeFirst();
        assertEquals(2, linkedList.size());
        linkedList.removeLast();
        assertEquals(1, linkedList.size());
        linkedList.removeFirst();
        assertEquals(0, linkedList.size());
    }

    @DisplayName("链表长度")
    @Test
    void sizeTest_removeLast() {
        assertEquals(4, linkedList.size());
        linkedList.deleteByNode("3-Node");
        assertEquals(3, linkedList.size());
        linkedList.removeFirst();
        assertEquals(2, linkedList.size());
        linkedList.removeLast();
        assertEquals(1, linkedList.size());
        linkedList.removeLast();
        assertEquals(0, linkedList.size());
    }

    @DisplayName("链表长度3")
    @Test
    void sizeTest_delAndAdd() {
        assertEquals(4, linkedList.size());
        linkedList.deleteByNode("3-Node");
        assertEquals(3, linkedList.size());
        linkedList.addElement("5-Node");
        assertEquals(4, linkedList.size());
        linkedList.removeFirst();
        assertEquals(3, linkedList.size());
        linkedList.insertToHead("0-Node");
        assertEquals(4, linkedList.size());
    }


    @Test
    void inverstLinkedListHeadTest() {
        linkedList.addElement("5-Node");
        linkedList.addElement("6-Node");
        linkedList.addElement("7-Node");

        Node node = linkedList.findElement("4-Node");
        final Node head = linkedList.inverstLinkedList_head(node);
        Node p = head;
        while (p != null) {
            System.out.print(p.getElement() + " ");
            p = p.next;
        }
    }

    @Test
    void inverstLinkedListTest() {
        linkedList.addElement("5-Node");
        linkedList.addElement("6-Node");
        linkedList.addElement("7-Node");

        Node node = linkedList.findElement("4-Node");
        Node newNode = linkedList.inverstLinkedList(node);

        while (newNode != null) {
            System.out.print(newNode.getElement() + " ");
            newNode = newNode.next;
        }
        System.out.println();

    }


    @Test
    void palindromeTest() {
        linkedList.addElement("3-Node");
        linkedList.addElement("2-Node");
        linkedList.addElement("1-Node");

        final boolean palindrome = linkedList.palindrome();
        assertTrue(palindrome);
    }
}