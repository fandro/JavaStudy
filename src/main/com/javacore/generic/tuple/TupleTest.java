package javacore.generic.tuple;

/**
 * 元组测试类.
 *
 * @author fuwb
 * @date 2020-06-01
 */
public class TupleTest {
    static Tuple2<String, Integer> f(){
        // 47 自动装箱
        return new Tuple2<>("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4<>(new Vehicle(),new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return new Tuple5<>(new Vehicle(),new Amphibian(), "hi", 47, 11.1);
    }

    //---------- 使用泛型方法优化后的元组方法  ------------

    public static <A, B> Tuple2<A, B> tuple(A a, B b) {
        return new Tuple2<>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> tuple(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);
    }

    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new Tuple5<>(a, b, c, d, e);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> f = f();
        System.out.println(f);
        // ttsi.a1 = "there"; // 编译错误，因为 final 不能重新赋值
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());

        // ---- 测试 优化后的方法-----
        // 请注意，f() 返回一个参数化的 Tuple2 对象，而 f2() 返回一个未参数化的 Tuple2 对象。编译器不会在这里警告 f2() ，因为返回值未以参数化方式使用。从某种意义上说，它被“向上转型”为一个未参数化的 Tuple2 。 但是，如果尝试将 f2() 的结果放入到参数化的 Tuple2 中，则编译器将发出警告。
        System.out.println(tuple("hi", 47));
        System.out.println(tuple(new Amphibian(),  "hi", 47));
        System.out.println(tuple(new Vehicle(), new Amphibian(), "hi", 47));
        System.out.println(tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1));
    }

}
