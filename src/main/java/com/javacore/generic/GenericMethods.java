package com.javacore.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法.
 *
 * @author fuwb
 * @since 2020-06-02
 */
public class GenericMethods {

    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    /**
     * 泛型方法和变长参数.
     * <pre>@SafeVarargs 注解保证不会对变长参数列表进行任何修改。</pre>
     * @param args
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> List<T> makeList(T... args) {
        List<T> list = new ArrayList<>();

        for (T arg : args) {
            list.add(arg);
        }
        //Collections.addAll(list, args);

        return list;
    }

    public static void main (String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        // 泛型方法的不需要指定参数类型，编辑器会进行类型参数推断，判断出类型。
        // 参数是基本类型时，会使用自动装箱，转为包装类
        genericMethods.f(" string");
        genericMethods.f(1);
        genericMethods.f(1.0);
        genericMethods.f(1.0F);
        genericMethods.f('c');
        genericMethods.f(genericMethods);

        List<String> list = makeList("A", "B", "C");
        System.out.println(list);
    }
}
