package com.net.jcip.examples.s3;

import com.net.jcip.annotations.*;

/**
 * MutableInteger
 * <p/>
 * Non-thread-safe mutable integer holder
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class MutableInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}








