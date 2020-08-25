package javacore.generic.replaceparams;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-04
 */
public class TestClazzB<U,K> // TestClazzB 实例化时指定实际类型
        extends TestClazzA<String> // 继承时指定实际类型
        implements TestInterface<K> // TestClazzB 实例化时指定实际类型，此处也可以直接指定实际类型
{
    U newField;
    // 泛型方法
    <E> void doIt(E e) { }

    public static void main(String[] args) {
        // TestClazzB 实例化时指定实际类型
        TestClazzB<Number, Integer> testClazzB = new TestClazzB<>();
        // 方法调用时指定实例类型
        testClazzB.doIt("string");


        List<String> list = new ArrayList<>();
        list.add("first");
        String f = list.get(0);

        List list2 = new ArrayList();
        list.add("first");
        String f2 = (String)list.get(0);
    }
}
