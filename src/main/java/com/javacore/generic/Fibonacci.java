package com.javacore.generic;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 斐波那契数列（Fibonacci sequence）
 * <pre>
 *    斐波那契数列（Fibonacci sequence），又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，
 *    指的是这样一个数列：1、1、2、3、5、8、13、21、34、……在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
 * </pre>
 * @author fuwb
 * @date 2020-06-01
 */
public class Fibonacci implements Supplier<Integer> {

    private int count = 0;

    @Override
    public Integer get() {
        return fib(count++);
    }

    public int fib(int n) {
        // 前两个数为1
        if (n < 2) {
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
                .limit(18)
                .map(n -> n + " ")
                .forEach(System.out::print);
    }
}
