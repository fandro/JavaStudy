package com.javacore.generic.wildcard;

import java.util.List;

/**
 * 使用超类型通配符，Apple 是下界
 * 可以声明通配符是由某个特定类的任何基类来界定的，
 * 方法是指定 <？super MyClass> ，或者甚至使用类型参数： <？super T>
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class SuperTypeWildcards {

    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }
}
