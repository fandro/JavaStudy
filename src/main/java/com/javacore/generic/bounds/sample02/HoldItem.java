package com.javacore.generic.bounds.sample02;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class HoldItem<T> {
    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}
