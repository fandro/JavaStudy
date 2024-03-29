package com.javacore.generic.factory.sample02;

import com.javacore.generic.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class Foo2<T> {

    private List<T> x = new ArrayList<>();

    Foo2(Supplier<T> factory) {
        Suppliers.fill(x, factory, 5);
    }

    @Override
    public String toString() {
        return x.toString();
    }
}
