package com.javacore.generic.wildcard;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); // No warning
        flist.contains(new Apple()); // Argument is 'Object'
        flist.indexOf(new Apple()); // Argument is 'Object'

        // 这里对 contains() 和 indexOf() 的调用接受 Apple 对象作为参数，执行没问题。
        // contains() 和 indexOf() 的参数类型是 Object，不涉及通配符，所以编译器允许调用它们。
        // 这是否意味着编译器实际上会检查代码，以查看是否有某个特定的方法修改了它的对象？
        // 尽管 add() 接受一个泛型参数类型的参数，但 contains() 和 indexOf() 接受的参数类型是 Object。
    }
}
