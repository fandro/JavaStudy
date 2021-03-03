package com.javacore.generic.tuple;

/**
 * 含有3种类型的元组.
 *
 * @author fuwb
 * @since 2020-06-01
 */
public class Tuple3<A, B, C> extends Tuple2<A, B> {

    public final C c3;

    public Tuple3(A a1, B b2, C c3) {
        super(a1, b2);
        this.c3 = c3;
    }

    @Override
    public String rep() {
        return super.rep() + "," + c3;
    }
}
