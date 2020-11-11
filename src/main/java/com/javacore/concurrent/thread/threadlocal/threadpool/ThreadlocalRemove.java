package com.javacore.concurrent.thread.threadlocal.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author feako
 * @date 2018/11/30
 */
public class ThreadlocalRemove {
    private BlockingQueue<Runnable> workQueue;
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    // 执行完后删除值
    ExecutorService executorService = new ThreadPoolExecutor(5,5,1, TimeUnit.MINUTES, workQueue, new ThreadPoolExecutor.DiscardPolicy()){
        @Override
        protected void afterExecute(Runnable r, Throwable t)
        {
            threadLocal.remove();
            super.afterExecute(r, t);
        }
    };

}
