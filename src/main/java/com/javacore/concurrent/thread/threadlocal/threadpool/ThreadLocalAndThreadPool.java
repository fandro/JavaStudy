package com.javacore.concurrent.thread.threadlocal.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程池和ThreadLocal
 *
 * @author feako
 * @since 2018/11/28
 */
public class ThreadLocalAndThreadPool {

    // 初始值1
    private static ThreadLocal<AtomicInteger> threadLocal = new ThreadLocal<AtomicInteger>(){
        @Override
        protected AtomicInteger initialValue() {
            return new AtomicInteger(0);
        }
    };
    // 初始值2
    private static ThreadLocal<AtomicLong> threadLocalLong = ThreadLocal.withInitial(()->new AtomicLong(0));

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
            AtomicInteger atomicInteger = threadLocal.get();
            // 返回的是 atomicInteger的值
            int andIncrement = atomicInteger.getAndIncrement();
            System.out.println(andIncrement);
        }
    }
}
