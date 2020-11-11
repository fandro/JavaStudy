package com.javacore.generic.tuple;

import java.util.ArrayList;

import static com.javacore.generic.tuple.TupleTest.tuple;

/**
 * 复杂模型-元组列表.
 * https://lingcoder.gitee.io/onjava8/#/book/20-Generics?id=%e6%9e%84%e5%bb%ba%e5%a4%8d%e6%9d%82%e6%a8%a1%e5%9e%8b
 *
 * @author fuwb
 * @date 2020-06-02
 */
public class TupleList<A, B, C, D> extends ArrayList<Tuple4<A, B, C, D>> {
    public static void main(String[] args) {

        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(tuple(new Vehicle(), new Amphibian(), "hi", 47));
        tl.add(tuple(new Vehicle(), new Amphibian(), "hi", 47));
        tl.forEach(System.out::println);
    }

}
