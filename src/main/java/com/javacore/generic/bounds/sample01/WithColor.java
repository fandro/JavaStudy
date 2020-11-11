package com.javacore.generic.bounds.sample01;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class WithColor<T extends HasColor> {
    T item;

    WithColor(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color getColor() {
        return item.getColor();
    }

}
