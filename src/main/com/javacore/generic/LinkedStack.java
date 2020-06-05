package javacore.generic;

/**
 * 用链式结构实现堆栈.
 * <p>
 *    参考：https://lingcoder.gitee.io/onjava8/#/book/20-Generics?id=%e4%b8%80%e4%b8%aa%e5%a0%86%e6%a0%88%e7%b1%bb
 * </p>
 *
 * @author fuwb
 * @date 2020-06-01
 */
public class LinkedStack<T> {

    /**
     * node拥有自己的泛型.
     * @param <U>
     */
    private static class Node<U> {
        /**
         * 栈元素.
         */
        U item;

        /**
         * 持有的下个栈指针。
         */
        Node<U> next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * 判断是否到达栈顶。
         *
         * @return
         */
        public boolean end() {
            return item == null && next == null;
        }
    }

    /**
     * 栈顶指针,初始化时的top对象为末端标识(item == null && next == null).
     */
    private Node<T> top = new Node<>();

    private void push(T item) {
        // 栈顶指针指向当前元素
        top = new Node<>(item, top);
    }

    private T pop() {
        T item = top.item;

        // 如果栈内有元素
        if (!top.end()) {
            // 移动栈顶指针
            top = top.next;
        }

        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        // 入栈
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        // 出栈
        String pop;
        while ((pop = lss.pop()) != null) {
            System.out.println(pop);
        }
    }

}
