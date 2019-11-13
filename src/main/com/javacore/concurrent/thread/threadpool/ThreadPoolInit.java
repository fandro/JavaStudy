package javacore.concurrent.thread.threadpool;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @author feako
 * @date 2018/11/2
 */
public class ThreadPoolInit implements Runnable{

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
        int corePoolSize = 10;
        int maxPoolSize = 50;
        long keepAliveTime = 30;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit, blockingQueue);

        BlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingDeque<>(20);
        ThreadFactory threadFactory = null;
        RejectedExecutionHandler handler = null;
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit, linkedBlockingQueue, threadFactory,handler);
    }


}
