package javacore.generic.bounds.sample02;

import javacore.generic.bounds.sample01.Coord;
import javacore.generic.bounds.sample01.HasColor;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class WithColorCoord2<T extends Coord & HasColor> extends WithColor2<T> {

    WithColorCoord2(T item) {
        super(item);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}
