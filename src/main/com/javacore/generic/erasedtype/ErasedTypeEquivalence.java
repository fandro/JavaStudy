package javacore.generic.erasedtype;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦除.
 * <p>
 *     https://lingcoder.gitee.io/onjava8/#/book/20-Generics?id=%e6%b3%9b%e5%9e%8b%e6%93%a6%e9%99%a4
 * </p>
 * @author fuwb
 * @date 2020-06-02
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        /**
         * ArrayList<String> 和 ArrayList<Integer> 应该是不同的类型。
         * 不同的类型会有不同的行为。new ArrayList<String>()不能放入Integer类型。
         * 事实上c1和c2是相同类型
         */
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        List<? extends Number> c3 = new ArrayList<>();

        System.out.println(c1 == c2);
        System.out.println(c3.getClass().getTypeParameters());
    }
}
