package java.stream;

import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * stream 流操作
 * <pre>
 *    stream 流操作过程： 1. 流生成  2. n个中间操作,每次中间操作都生成一个新的流 3. 流的终止操作
 *    流原始：1.对象引用 Stream<Person> 2. 原始类型流：IntStream,LongStream,DoubleStream
 *
 * </pre>
 *  <pre>
 *      参考：
 *      1. Java8初体验（二）Stream语法详解 http://ifeve.com/stream/
 *      2. JDK8- java.util.stream 库笔记 https://www.cnblogs.com/litaiqing/p/6026682.html
 *  </pre>
 * @author fuwb
 * @date 2018/4/27
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Person> list = initPersons();

        // 创建流
        Stream<Person> stream = Stream.empty();
        for (int i = 1; i < 10; i++) {
            stream = generateStream(list, i);
        }

        // 流操作



    }

    /**
     * 创建stream的方式
     * @param i
     * @return
     */
    private static Stream<Person> generateStream(List<Person> list, int i) {
        Stream<Person> stream = null;
        switch (i) {
            case 1:
                // Collection默认方法：创建 串行stream
                stream = list.stream();
                break;
            case 2:
                // Collection默认方法：创建并行stream
                stream = list.parallelStream();
                break;
            case 3:
                // Stream静态方法-of方法： 使用传递给工厂方法的参数创建一个流
                stream = Stream.of(new Person("zhangfei",15,"beijing"), new Person("zhaoyun",18,"shanghai"));
                break;
            case 4:
                // Stream静态方法-of方法： 使用数组元素创建一个流
                Person[] persons = {new Person("zhangfei",15,"beijing"),new Person("zhaoyun",18,"shanghai")};
                stream = Stream.of(persons);
                break;
            case 5:
                // Stream静态方法-创建空流，用于初始化赋值
                stream = Stream.empty();
                break;
            case 6:
                // Stream静态方法-generate方法：1.生成无限长stream 2.懒加载 3.get方法中定义生成规则 4.常配合limit()使用
                Stream.generate(new Supplier<Person>(){
                    @Override
                    public Person get() {
                        int random = (int)Math.random();
                        return new Person("random"+random, random,"address"+random);
                    }
                }).limit(100);
                break;
            case 7:
                // Stream静态方法-iterate方法：1.生成无限长stream 2.懒加载 3.循环对变量(it)进行计算 4.常配合limit()使用
                Stream.iterate(1,it -> it + 1).limit(10);
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                break;

        }
        return stream;
    }

    /**
     * 整数聚合运算
     * @return
     */
    private int intAggragate() {
        int sum = Stream.of(Month.values()) // 创建流
                         .filter(m -> (m.getValue() == Month.MARCH.getValue() || m.getValue() == Month.AUGUST.getValue())) // 转换成新的流
                         .mapToInt(m -> m.getValue()) // 转换成新的流
                         .sum();// 聚合
        return sum;
    }

    /**
     * generate方法,生成无限长度stream，无限长度stream是懒加载，经常配置limit()使用，
     * @return
     */
    private Stream generateTest() {
        Stream<Double> stream = Stream.empty();
        // 形式1
        stream = Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });
        // 形式2
        stream = Stream.generate(() -> Math.random());
        // 形式3
        stream = Stream.generate(Math::random);
        return stream;
    }

    private static List<Person> initPersons() {
        return Arrays.asList(
          new Person("zhangfei",15,"beijing"),
          new Person("zhaoyun",18,"shanghai"),
          new Person("liubei",20,"shenzhen"),
          new Person("zhugeliang",25,"guangzhou"),
          new Person("guanyu",30,"hangzhou"),
          new Person("xiangyu",30,"chongqing")
        );
    }

    static class Person {
        public Person(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        private String name;
        private int age;
        private String address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}

