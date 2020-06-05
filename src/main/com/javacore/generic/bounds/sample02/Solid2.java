package javacore.generic.bounds.sample02;

import javacore.generic.bounds.sample01.Coord;
import javacore.generic.bounds.sample01.HasColor;
import javacore.generic.bounds.sample01.Weight;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class Solid2<T extends Coord & HasColor & Weight> extends WithColorCoord2<T>  {

    Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}
