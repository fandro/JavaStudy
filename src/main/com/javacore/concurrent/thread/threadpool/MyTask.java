package javacore.concurrent.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author feako
 * @date 2018/11/2
 */
public class MyTask implements Runnable{

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ": Thread ID " + Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            fixedExecutorService.submit(task);
        }
        fixedExecutorService.shutdown();

    }
}
