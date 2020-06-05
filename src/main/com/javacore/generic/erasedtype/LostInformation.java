package javacore.generic.erasedtype;

import java.util.*;


class Frob {}
class Fnorkle {}

/**
 * 物理概念：夸克
 * @param <Q>
 */
class Quark<Q> {}

/**
 * 物理概念：粒子.
 * @param <POSITION> 位置
 * @param <MOMENTUM> 动量
 */
class Particle<POSITION, MOMENTUM> {}

/**
 * 泛型擦除，信息丢失.
 *
 * @author fuwb
 * @date 2020-06-02
 */
public class LostInformation {
    public static void main(String[] args) {
        ArrayList<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters())); // [E]
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));  // [K, V]
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));// [Q]
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));    // [POSITION, MOMENTUM]
        /**
         * getTypeParameters()并没有返回具体的类型，而是只返回了用作参数占位符的标识符。
         *
         * 残酷的现实是：在泛型代码内部，无法获取任何有关泛型参数类型的信息。
         * java泛型是擦除实现，意味着任何具体的类型信息都会被擦除。
         */
    }
}
