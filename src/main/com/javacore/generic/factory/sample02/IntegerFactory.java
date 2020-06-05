package javacore.generic.factory.sample02;

import java.util.function.Supplier;

/**
 * 创建工厂方法一 ： 直接实现Supplier。
 * IntegerFactory 本身就是通过实现 Supplier<Integer> 的工厂
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class IntegerFactory implements Supplier<Integer> {
    private int i = 0;

    @Override
    public Integer get() {
        return ++i;
    }
}
