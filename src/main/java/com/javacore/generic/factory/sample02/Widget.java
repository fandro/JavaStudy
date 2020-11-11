package com.javacore.generic.factory.sample02;

import java.util.function.Supplier;

/**
 * 创建工厂方法二 ： 内部态类实现Supplier。
 * Widget 包含一个内部类，它是一个工厂
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class Widget {
    private int id;

    Widget(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return "Widget " + id;
    }

    public static class Factory implements Supplier<Widget> {
        private int i = 0;

        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}
