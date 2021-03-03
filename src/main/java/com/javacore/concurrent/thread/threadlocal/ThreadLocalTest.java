package com.javacore.concurrent.thread.threadlocal;

/**
 * 也就是说这个类给线程提供了一个本地变量，这个变量是该线程自己拥有的。
 * 在该线程存活和ThreadLocal实例能访问的时候,保存了对这个变量副本的引用.当线程消失的时候，
 * 所有的本地实例都会被GC。
 * 并且建议我们ThreadLocal最好是 private static 修饰的成员
 *
 * @author feako
 * @since 2018/11/26
 */
public class ThreadLocalTest {

    private static ThreadLocal<Long> longThreadLocal = new ThreadLocal(){
        // 没法调用set赋值时，调用get获取初始值
        @Override
        protected Object initialValue() {
            return Thread.currentThread().getId();
        }
    };

    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal(){
        // 没法调用set赋值时，调用get获取初始值
        @Override
        protected Object initialValue() {
            return Thread.currentThread().getName();
        }
    };

    public static long getLong() {
        return longThreadLocal.get();
    }

    public static String getString() {
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.getString();
        System.out.println("initValue="+ThreadLocalTest.getString()+";initValue tId="+ThreadLocalTest.getLong());

        Thread thread1 = new Thread("t1") {
            @Override
            public void run() {
                // thread1中赋值
                longThreadLocal.set(11L);
                stringThreadLocal.set("t11");
                System.out.println("threadName="+ThreadLocalTest.getString()+"; threadId="+ThreadLocalTest.getLong());
                // 使用完移除
                longThreadLocal.remove();
                stringThreadLocal.remove();
            }
        };

        Thread thread2 = new Thread("t2") {
            @Override
            public void run() {
                // thread2中赋值
                longThreadLocal.set(12L);
                stringThreadLocal.set("t12");
                System.out.println("threadName="+ThreadLocalTest.getString()+"; threadId="+ThreadLocalTest.getLong());
                longThreadLocal.remove();
                stringThreadLocal.remove();
            }
        };

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        stringThreadLocal.remove();
        longThreadLocal.remove();
    }

}
