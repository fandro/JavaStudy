package javacore.concurrent.thread.threadlocal.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author feako
 * @date 2018/11/30
 */
public class ThreadTest {
    static ExecutorService defaultFixedExecutor = Executors.newFixedThreadPool(1);
    static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            final int count = i;
            defaultFixedExecutor.submit(new Runnable() {

                @Override
                public void run() {
                    System.out.println("第"+count+"次ThreadLocal 值为："+threadLocal.get());
                    threadLocal.set(count+"");
                    System.out.println("第"+count+"次结束，ThreadLocal值为："+threadLocal.get());
                    System.out.println("当前线程名称为："+Thread.currentThread().getName());
                    System.out.println(" ");
                }
            });

        }
    }
}
