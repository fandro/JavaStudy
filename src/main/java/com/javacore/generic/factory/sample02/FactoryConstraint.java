package com.javacore.generic.factory.sample02;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        // 创建工厂方法1
        System.out.println(new Foo2<>(new IntegerFactory()));
        // 创建工厂方法2
        System.out.println(new Foo2<>(new Widget.Factory()));
        // Fudge::new 仍然会产生工厂行为，因为编译器将对函数方法 ::new 的调用转换为对 get() 的调用
        System.out.println(new Foo2<>(Fudge::new));
    }
}
