package com.javacore.concurrent.thread.threadlocal;

/**
 * 异步子线程怎么拿到父线程的ThreadLocal数据？
 * jdk给我们提供了解决办法，ThreadLocal有一个子类InheritableThreadLocal，
 * 创建ThreadLocal时候我们采用InheritableThreadLocal类可以实现子线程获取到父线程的本地变量。
 * 然后子线程中就可以正常拿到user对象了。
 *
 * 当我们执行异步任务时，大多会采用线程池的机制(如Executor)。
 * 这样就会存在一个问题，即使父线程已经结束，子线程依然存在并被池化。
 * 这样，线程池中的线程在下一次请求被执行的时候，
 * ThreadLocal的get()方法返回的将不是当前线程中设定的变量，
 * 因为池中的“子线程”根本不是当前线程创建的，当前线程设定的ThreadLocal变量也就无法传递给线程池中的线程。
 *
 * @author feako
 * @date 2018/11/30
 */
public class ThreadLocalInheritable {
    private static ThreadLocal<String> userResource = new InheritableThreadLocal<String>();


}
