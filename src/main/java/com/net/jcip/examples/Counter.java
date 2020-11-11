package com.net.jcip.examples;

/**
 * Counter
 * <p/>
 * Simple thread-safe counter using the Java monitor pattern
 *
 * @author Brian Goetz and Tim Peierls
 */
@com.net.jcip.annotations.ThreadSafe
public final class Counter {
    @com.net.jcip.annotations.GuardedBy("this") private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }
}
