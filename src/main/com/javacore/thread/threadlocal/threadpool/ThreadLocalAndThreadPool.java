package javacore.thread.threadlocal.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池和ThreadLocal
 *
 * @author fuwb
 * @date 2018/11/28
 */
public class ThreadLocalAndThreadPool {

    private static ThreadLocal<AtomicInteger> t = new ThreadLocal<AtomicInteger>(){
        @Override
        protected AtomicInteger initialValue() {
            return new AtomicInteger(0);
        }
    };

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.shutdown();
    }


    private static class Task implements Runnable {

        @Override
        public void run() {
            AtomicInteger atomicInteger = t.get();
            // 返回的是 atomicInteger的值
            int andIncrement = atomicInteger.getAndIncrement();
            System.out.println(andIncrement);
        }
    }
}
