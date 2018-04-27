package net.jcip.examples.s3;

import net.jcip.annotations.*;

/**
 * SynchronizedInteger
 * <p/>
 * Thread-safe mutable integer holder
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this") private int value;
    
    /**
     * 如果不同步该方法，不能看到最新数据，仍然可以看到过期数据，没能保证可见性。
     *
     * @return the int
     */
    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
