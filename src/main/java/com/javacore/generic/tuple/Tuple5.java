package com.javacore.generic.tuple;

/**
 * 含有5种类型的元组
 *
 * @author fuwb
 * @date 2020-06-01
 */
public class Tuple5<A, B, C, D, E> extends Tuple4<A, B, C, D>{
    public E e5;

    public Tuple5(A a1, B b2, C c3, D d4, E e5) {
        super(a1, b2, c3, d4);
        this.e5 = e5;
    }

    @Override
    public String rep() {
        return super.rep() + "," +e5;
    }
}
