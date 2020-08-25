package javacore.generic.factory.sample01;

/**
 * 工厂对象，并使用该对象创建新实例.
 *
 * 于错误不是在编译时捕获的，因此语言创建者不赞成这种方法。
 * 建议使用显式工厂并约束类型（Supplier<Integer>）.
 * <p>
 *   https://lingcoder.gitee.io/onjava8/#/book/20-Generics?id=%e5%88%9b%e5%bb%ba%e7%b1%bb%e5%9e%8b%e7%9a%84%e5%ae%9e%e4%be%8b
 * </p>
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> factory = new ClassAsFactory<>(Employee.class);
        System.out.println(factory.get());

        ClassAsFactory<Integer> fei = new ClassAsFactory<>(Integer.class);

        try {
            // 对于 ClassAsFactory<Integer> 会失败，这是因为 Integer 没有无参构造函数。
            System.out.println(fei.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
