package com.javacore.generic.bounds.sample01;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> boundedSolid = new Solid<>(new Bounded());
        // HasColor接口中方法
        boundedSolid.color();
        // Coord类型中的属性
        boundedSolid.getY();
        // Weight接口中的方法
        boundedSolid.weight();

    }
}
