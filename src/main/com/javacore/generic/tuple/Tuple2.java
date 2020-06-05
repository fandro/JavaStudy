package javacore.generic.tuple;

/**
 * 含有两种类型的元组
 *
 * @author fuwb
 * @date 2020-06-01
 */
public class Tuple2<A, B> {
    /**
     * public final 比 (private + getter)方式更简洁
     */
    public final A a1;

    public final B b1;

    public Tuple2(A a1, B b1) {
        this.a1 = a1;
        this.b1 = b1;
    }

    public String rep() {
        return a1 + "," + b1;
    }

    @Override
    public String toString() {
        return "Tuple2{" +
                "a1=" + a1 +
                ", b1=" + b1 +
                '}';
    }


}
