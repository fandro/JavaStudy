package javacore.thread.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 即使对象是线程安全的，使用ThreadLocal也可以减少竞争，比如对于Random类来说，
 * Random是线程安全的，但是如果并发访问竞争激烈的化，性能会下降，
 * 所以Java并发包提供了类TheadLocalRandom，
 * 它是Random的子类，利用了ThreadLocal，它没有public的构造方法，通过静态方法current获取对象。(jdk1.7)
 *
 * @author fuwb
 * @date 2018/11/28
 */
public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        System.out.println(tlr.nextInt());
    }
}
