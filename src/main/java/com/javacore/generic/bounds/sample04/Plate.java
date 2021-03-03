package com.javacore.generic.bounds.sample04;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class Plate<T> {

    private T item;

    public Plate(T t) {
        item=t;
    }

    public void set(T t){
        item=t;
    }

    public T get() {
        return item;
    }
}
