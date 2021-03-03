package com.javacore.generic.factory.sample01;

import java.util.function.Supplier;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class ClassAsFactory<T> implements Supplier<T> {
    Class<T> kind;

    ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }

    @Override
    public T get() {
        try {
            return kind.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
