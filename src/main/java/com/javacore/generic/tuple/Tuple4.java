package com.javacore.generic.tuple;

/**
 * 含有4种类型的元组
 *
 * @author fuwb
 * @since 2020-06-01
 */
public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {
    public final D d4;

    public Tuple4(A a1, B b2, C c3, D d4) {
        super(a1, b2, c3);
        this.d4 = d4;
    }

    @Override
    public String rep() {
        return super.rep() + "," +d4;
    }
}
