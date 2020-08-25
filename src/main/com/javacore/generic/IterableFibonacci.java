package javacore.generic;

import java.util.Iterator;

/**
 * 编写一个实现了 Iterable 的 Fibnoacci 生成器。
 *  <p>
 *      https://lingcoder.gitee.io/onjava8/#/book/20-Generics?id=%e6%b3%9b%e5%9e%8b%e6%8e%a5%e5%8f%a3
 *  </p>
 * @author fuwb
 * @date 2020-06-02
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFibonacci(int count) { n = count; }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() { return n > 0; }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.get();
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}
