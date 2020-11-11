package com.javacore.generic;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-02
 */
public class Suppliers {

    /**
     * Create a collection and fill it
     * @param factory
     * @param gen
     * @param n
     * @param <T>
     * @param <C>
     * @return
     */
    public static <T, C extends Collection<T>> C create(Supplier<C> factory, Supplier<T> gen, int n) {
        return Stream.generate(gen)
                .limit(n)
                .collect(factory, C::add, C::addAll);
    }

    /**
     * Fill an existing collection
     * @param coll
     * @param gen
     * @param n
     * @param <T>
     * @param <C>
     * @return
     */
    public static <T, C extends Collection<T>> C fill(C coll, Supplier<T> gen, int n) {
        Stream.generate(gen)
                .limit(n)
                .forEach(coll::add);
        return coll;
    }

    /**
     * Use an unbound method reference to produce a more general method:
     * @param holder
     * @param adder
     * @param gen
     * @param n
     * @param <H>
     * @param <A>
     * @return
     */
    public static <H, A> H fill(H holder, BiConsumer<H, A> adder, Supplier<A> gen, int n) {
        Stream.generate(gen)
                .limit(n)
                .forEach(a -> adder.accept(holder, a));
        return holder;
    }
}
