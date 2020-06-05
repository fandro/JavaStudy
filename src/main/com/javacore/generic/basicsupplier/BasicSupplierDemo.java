package javacore.generic.basicsupplier;

import java.util.stream.Stream;

/**
 * BasicSupplier 产生对象demo.
 *
 * @author fuwb
 * @date 2020-06-02
 */
public class BasicSupplierDemo {
    public static void main(String[] args) {
        // BasicSupplier 可以轻松地为 CountedObject 创建 Supplier
        Stream.generate(BasicSupplier.create(CountedObject.class))
                .limit(5)
                .forEach(System.out::println);
    }
}
