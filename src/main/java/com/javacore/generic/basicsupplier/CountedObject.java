package com.javacore.generic.basicsupplier;

/**
 * 具有无参数构造函数的简单类。
 * CountedObject 类可以跟踪自身创建了多少个实例，并通过 toString() 报告这些实例的数量。
 *
 * @author fuwb
 * @since 2020-06-02
 */
public class CountedObject {

    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }
}
