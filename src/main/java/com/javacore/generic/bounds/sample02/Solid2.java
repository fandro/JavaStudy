package com.javacore.generic.bounds.sample02;

import com.javacore.generic.bounds.sample01.Coord;
import com.javacore.generic.bounds.sample01.HasColor;
import com.javacore.generic.bounds.sample01.Weight;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class Solid2<T extends Coord & HasColor & Weight> extends WithColorCoord2<T>  {

    Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}
