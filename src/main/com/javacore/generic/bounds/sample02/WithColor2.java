package javacore.generic.bounds.sample02;

import javacore.generic.bounds.sample01.HasColor;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class WithColor2<T extends HasColor> extends HoldItem<T> {

    WithColor2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();
    }
}
