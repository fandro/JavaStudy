package javacore.generic.bounds.sample02;

import javacore.generic.bounds.sample01.Bounded;

/**
 * HoldItem 拥有一个对象，因此此行为将继承到 WithColor2 中，这也需要其参数符合 HasColor。
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class InheritBounds {

    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());

        solid2.color();
        solid2.getY();
        solid2.weight();

    }
}
