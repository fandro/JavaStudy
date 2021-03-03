package com.javacore.stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream 流操作
 * <pre>
 *    stream 流操作过程： 1. 流生成  2. n个中间转换流操作,每次转换操作都生成一个新的流 3. 流的终止操作
 *    流原始：1.对象引用 Stream<Person> 2. 原始类型流：IntStream,LongStream,DoubleStream
 *    终止流操作：
 *    forEach: 操作流的每一个元素
 *    toArray() 使用流元素创建一个数组
 *    reduce : 将流的元素聚合为一个汇总值
 *    collect :将流的元素聚合到一个容器中
 *    min() : 返回最小值
 *    max : 返回最大值
 *    count : 统计流元素的数量
 *    sum : 求和
 *    {any,all,none}Match(Predicate<T>)	: 返回匹配的流元素
 *    findFirst : 返回第一个元素
 *    findAny : 返回任意一个元素
 *
 *    术语：短路 -short-circuiting
 * </pre>
 * <pre>
 *
 *     Intermediate：
 *  map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered

 *  Terminal：
 *  forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator

 * Short-circuiting：
 *  anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 * </pre>
 *  <pre>
 *      参考：
 *      1. Java8初体验（二）Stream语法详解 http://ifeve.com/stream/
 *      2. JDK8- java.util.stream 库笔记 https://www.cnblogs.com/litaiqing/p/6026682.html
 *      3.https://blog.csdn.net/qq_34378776/article/details/73521652
 *      4. https://blog.csdn.net/walkerjong/article/details/50633474
 *      5. https://www.cnblogs.com/CarpenterLee/p/6550212.html
 *      6.https://blog.csdn.net/qq_33605778/article/details/78988392
 *  </pre>
 * @author feako
 * @since 2018/4/27
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Person> list = initPersons();

        // ---- 创建流 ----
        Stream<Person> stream = Stream.empty();
        for (int i = 1; i < 10; i++) {
            stream = generateStream(list, i);
        }

        // ---- 转换流操作 ----
        // distinct: 对元素进行去除操作
        generateStream(list, 1).distinct().forEach(System.out::println);


    }


    //------------------------- 筛选与切片 filter,limit,skip,distinct ---------------------------------------

    /**
     * filter: 对元素进行过滤操作，符号条件的元素组成新的流
     */
    @Test
    public void filterTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        System.out.println("---- 年龄大于20的人 ----");
        stream.filter(it -> it.getAge() > 20).forEach(System.out::println);
    }

    /**
     * limit: 截断流，使其元素不超过给定数量。
     */
    @Test
    public void limitTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        System.out.println("---- 年龄大于20的2个人----");
        stream.filter(it->it.getAge()>20)
                .limit(2)
                .forEach(System.out::println);
    }

    /**
     * skip:跳过前n个元素，若不足n个则返回空流，与 limit(n) 互补
     */
    @Test
    public void skipTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        System.out.println("---- 年龄大于20的人，忽略前2个人----");
        stream.filter(it->it.getAge()>20)
                .skip(2)
                .forEach(System.out::println);

    }

    /**
     * distinct:对元素进行去除操作，根据hashCode和equals判断相等
     */
    @Test
    public void distinctTest() {
        List<Person> list = initPersons();
        System.out.println("---- 信息相同的人去重 ----");
        generateStream(list, 1).distinct().forEach(System.out::println);
    }

    //------------------------- 映射、排序 map flatMap sort peek foreach---------------------------------------

    /**
     * map: 将元素转换成其他类型(形式)，接受函数做为参数，函数应用每一个元素，并映射成新元素
     * map可以无需级联：map().map().map()...
     * mapToInt（对象转换成int类型）,mapToLong,mapToDouble
     */
    @Test
    public void mapTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        System.out.println("---- 年龄大于25的人的名称 ----");

        stream.filter(it-> it.getAge() > 25)
            .map(person -> { return person.getName(); })
            .distinct()
            .forEach(System.out::println);

        stream.filter(it-> it.getAge() > 25)
                .map(person -> { return person.getName(); })
                .distinct()
                .forEach(System.out::println);

    }

    /**
     * flatMap : 把二维集合转换为一维或者把多个集合合并成一个集合流
     */
    @Test
    public void flatMapTest() {
        System.out.println("---- 把多个集合遍历一遍 ----");
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9));
        listStream.flatMap(Collection::stream).forEach(System.out::println);
    }

    /**
     * peek如同foreach,只是不会中断流操作,
     * peek 传参是consumer, 保持原对象不变,
     * map 传参是function，需要返回新对象
     */
    @Test
    public void peekTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        System.out.println("---- 年龄大于25的人的名称 ----");

        stream.filter(it-> it.getAge() > 25)
                .peek(System.out::println)
                .map(person -> { return person.getName(); })
                .peek(System.out::println)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * sorted() 自然排序
     * sorted(Comparator com) 定制排序
     */
    @Test
    public void sortedTest() {
        System.out.println("---- 年龄排序 ----");
        Stream<Person> stream1= generateStream(initPersons(), 1);
        stream1.distinct().sorted((e1,e2) ->{
            if (e1.getAge() == e2.getAge()) {
                return 0;
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        }).forEach(System.out::println);
    }

    //------------------------- 匹配 match ---------------------------------------

    /**
     * 全部匹配
     */
    @Test
    public void allMatchTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        boolean allMatch = stream.allMatch(it -> "china".equals(it.getContry()));
        System.out.println("---- 是否全部中国人 ----"+allMatch);
    }

    /**
     * 任意一个匹配
     */
    @Test
    public void anyMatchTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        boolean anyMatch = stream.anyMatch(it -> "beijing".equals(it.getAddress()));
        System.out.println("---- 有北京人 ---- " + anyMatch);
        Stream<Person> stream1 = generateStream(initPersons(), 1);
        boolean anyMatch1 = stream1.anyMatch(it -> "tianjin".equals(it.getAddress()));
        System.out.println("---- 有天津人 ---- " + anyMatch1);
    }

    /**
     * 没有一个匹配
     */
    @Test
    public void noneMatchTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        boolean noneMatch = stream.noneMatch(it -> it.getAge() > 60);
        System.out.println("---- 没有年龄超过60的人 = " + noneMatch);

    }

    /**
     * 查找任意一个(串行流是第一个，并行流是任意一个)
     */
    @Test
    public void findAnyTest() {
        Stream<Person> stream = generateStream(initPersons(), 2);
        Person person = stream.findAny().get();
        System.out.println("---- 找任意一个人 ----"+person);

    }

    /**
     * 返回第一个匹配的结果
     */
    @Test
    public void findFirstTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Person person1 = stream.filter(it -> it.getAge() > 25).findFirst().get();

        Stream<Person> stream2 = generateStream(initPersons(), 1);
        Optional<Person> person2 = stream2.filter(it -> it.getAge() > 65).findFirst();
        // Optional 模仿 Scala 语言中的概念，作为一个容器，它可能含有某值，或者不包含。使用它的目的是尽可能避免 NullPointerException。

        Person p = Optional.ofNullable(person2).get().orElse(new Person());
        String name = person2.isPresent() ? person2.get().getName(): StringUtils.EMPTY;
        person2.ifPresent(it -> it.getAge());

        System.out.println("---- 大于25的第一个人 ----" + p);
    }

    /**
     * 统计元素数量
     */
    @Test
    public void countTest() {
        // 使用并行流
        Stream<Person> stream = generateStream(initPersons(), 2);
        long count = stream.filter(it -> it.age > 25).distinct().count();
        System.out.println("----  大于25岁的人有" + count + "个 ----");

    }

    /**
     * 比较运算得出最大值对象
     */
    @Test
    public void maxTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Person person = stream.distinct().max((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return 0;
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        }).get();
        System.out.println("---- 年龄最大的人是 ----" +person );
    }

    /**
     * 比较运算得出最小值对象
     */
    @Test
    public void minTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Person person = stream.distinct().min((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return 0;
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        }).get();
        System.out.println("---- 年龄最小的人是 ----" +person );

    }



    //------------------------- collect 分组，分区 ---------------------------------------
    /* 使用一个collector执行mutable reduction操作。辅助类 Collectors 提供了很多的collector，可以满足我们日常的需求，
    * 你也可以创建新的collector实现特定的需求。它是一个值得关注的类，你需要熟悉这些特定的收集器，
    * 如聚合类averagingInt、最大最小值maxBy minBy、计数counting、分组groupingBy、字符串连接joining、
    * 分组groupingBy、 分区partitioningBy、汇总summarizingInt、化简reducing、转换toXXX等。
    */
    // maxBy
    // 求最大年龄
    //Optional<Student> olderStudent = students.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
    // 进一步简化
    //Optional<Student> olderStudent2 = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
    // 求最小年龄
    //Optional<Student> olderStudent3 = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
    //求年龄总和
    //int totalAge4 = students.stream().collect(Collectors.summingInt(Student::getAge));
    //字符串拼接
    //String names = students.stream().map(Student::getName).collect(Collectors.joining());
    //String names = students.stream().map(Student::getName).collect(Collectors.joining(", "));



    /**
     * 分组
     */
    @Test
    public void collectGroupingByTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        System.out.println("---- ----");

    }

    /**
     * 分区
     */
    @Test
    public void collectPartitioningTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        System.out.println("---- ----");

    }

    /**
     * 多级分组
     */
    @Test
    public void collectGroupTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        System.out.println("---- ----");

    }

    //------------------------- Stream reduce 归约与收集 （流转换为其它数据结构）---------------------------------------
    //  collect——将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法

    /**
     * stream转为为list
     */
    @Test
    public void streamToArray() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Person[] peoples1 = stream.toArray(p -> new Person[initPersons().size()]);
        Person[] peoples2 = stream.toArray(Person[]::new);
        Object[] peoples3 = stream.toArray();
        System.out.println("---- ---- "+peoples2);

    }

    /**
     * stream转为为list
     */
    @Test
    public void toList() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        List<Person> personList = stream.collect(Collectors.toList());
        System.out.println("---- ----");

    }

    /**
     * list转map.
     */
    @Test
    public void listToMap() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        List<Person> personList = stream.collect(Collectors.toList());

        personList.sort(Comparator.comparing(Person::getAge));
        List<Person> collect = personList.stream()
                .sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());

        Map<String, Person> personMap = personList.stream()
                .collect(Collectors.toMap(person -> person.getName(), person -> person));

        Map<String, Person> personMap2 = personList.stream()
                .collect(Collectors.toMap(Person::getName, person -> person));

        // key重复时选择不覆盖
        Map<String, Person> personMap3 = personList.stream()
                .collect(Collectors.toMap(Person::getName, person -> person, (existing, replacement)-> existing));

        // 最后，让我们看看如何返回一个排序后的Map。为此，我们需要对List<Book>进行排序，并使用TreeMap作为mapSupplier参数:
        Map<String, Person> personMap4 = personList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toMap(Person::getName, Function.identity(), (existing, replacement)-> existing, TreeMap::new));


    }

    /**
     * stream转为为数组
     */
    @Test
    public void toArray() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Person[] personList = (Person[]) stream.toArray();
        System.out.println("---- ----");

    }

    /**
     * stream转为为 toCollection
     */
    @Test
    public void toCollection() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        ArrayList<Person> personArrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        System.out.println("---- ----");

    }

    /**
     * stream转为为set
     */
    @Test
    public void toSet() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Set<Person> personList = stream.collect(Collectors.toSet());
        System.out.println("---- ----");

    }
    /**
     * stream转为为stack
     */
    @Test
    public void toStack() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Stack<Person> stack = stream.collect(Collectors.toCollection(Stack::new));
        System.out.println("---- ----");

    }
    /**
     * stream转为数组字符串
     */
    @Test
    public void StreamToString() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        String string = stream.map(it -> it.getName()).collect(Collectors.joining(",")).toString();
        System.out.println("----数组 ----"+string);
    }

    /**
     * groupingBy 分组
     */
    @Test
    public void groupingByTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Map<Person, Long> collect = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("---- 小于等于25 ="+ collect.get(true) +"---- 大于25 ="+ collect.get(false));
        Stream<Person> stream2 = generateStream(initPersons(), 1);
        //Map<Person, Long> collect2 = stream.collect(Collectors.groupingBy(Person::getAddress, Collectors.counting()));

        /*Map<Status, Map<String, List<Emp>>> map = emps.stream()
                .collect(Collectors.groupingBy(Emp::getStatus, Collectors.groupingBy((e)->{
                    if(e.getAge()>60)
                        return "老年"  ;
                    else if(e.getAge()>35)
                        return "中年"   ;
                    else
                        return "成年"  ;
                })))   ;
        System.out.println(map);*/
    }

    /**
     * groupingBy 分组
     */
    @Test
    public void groupingByTest2() {
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);
    }

    /**
     * groupingBy 分组
     */
    /*@Test
    public void groupingByTest3() {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);
    }*/

    /*public void groupingbyTest4(){
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        System.out.println(result);
    }*/

    /**
     * partitioning 分区，使用一个条件，一分为二。形成一个map结构
     * get(true) 和 get(false) 能即为全部的元素对象
     */
    @Test
    public void partitioningTest() {
        Stream<Person> stream = generateStream(initPersons(), 1);
        Map<Boolean, List<Person>> listMap = stream.collect(Collectors.partitioningBy(it -> it.getAge() <= 25));
        System.out.println("---- 小于等于25 ="+ listMap.get(true) +"---- 大于25 ="+ listMap.get(false));
        // 分区是特殊的分组
        Stream<Person> stream2 = generateStream(initPersons(), 1);
        Map<Boolean, List<Person>> listMap2 = stream2.collect(Collectors.groupingBy(it -> it.getAge() <= 25));
        System.out.println("---- 小于等于25 ="+ listMap2.get(true) +"---- 大于25 ="+ listMap2.get(false));

    }

    @Test
    public void reduceTest1() {
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10)  ;
        Integer sum = list.stream().reduce(0, (x, y)->x+y)   ;
        System.out.println(sum);
        System.out.println("-------------------") ;
        Stream<Person> stream = generateStream(initPersons(), 1);

        Optional<Integer> sum2 = stream
                .map(Person::getAge)
                .reduce(Integer::sum)  ;
        System.out.println(sum2.orElse(0))  ;
    }


    @Test
    public void reduceTest2() {
        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        // 参数 Optional<T> reduce(BinaryOperator<T> accumulator);
        // a 为累加结果，b为本次数值
        int result = numList.stream().reduce((a,b) -> a + b ).get();
        System.out.println(result);
    }

    @Test
    public void reduceTest3() {
        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        // 参数 T reduce(T identity, BinaryOperator<T> accumulator);
        // identity 首次执行时表达式参与的值，并不是stream的第一个元素
        // 此处表示从10开始累加
        int result = numList.stream().reduce(10,(a,b) ->  a + b );
        System.out.println(result);
    }

    @Test
    public void reduceTest4() {
        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        // 参数 <U> U reduce(U identity,
        //                 BiFunction<U, ? super T, U> accumulator,
        //                 BinaryOperator<U> combiner);
        // 此形式可以进行类型转换
        ArrayList<String> result = numList.stream().reduce(new ArrayList<String>(),
                (a, b) -> {
                    a.add("element-" + Integer.toString(b));
                    return a;
                    },
                (a, b) -> null);
        System.out.println(result);
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
                // Collection 默认方法：创建流, 默认是串行流
                stream = list.stream();
                break;
            case 2:
                // Collection默认方法：创建并行stream,没有特定的先后顺序
                stream = list.parallelStream();
                break;
            case 3:
                // Stream静态方法-of方法： 使用传递给工厂方法的参数创建一个流
                stream = Stream.of(new Person("zhangfei",15,"beijing","china"), new Person("zhaoyun",18,"shanghai","china"));
                break;
            case 4:
                // Stream静态方法-of方法： 使用数组元素创建一个流
                Person[] persons = {new Person("zhangfei",15,"beijing","china"),new Person("zhaoyun",18,"shanghai","china")};
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
                        return new Person("random"+random, random,"address"+random,"china");
                    }
                }).limit(100);
                break;
            case 7:
                // Stream静态方法-iterate方法：1.生成无限长stream 2.懒加载 3.循环对变量(it)进行计算 4.常配合limit()使用
                Stream.iterate(1,it -> it + 1).limit(10);
                break;
            case 8:
                Person[] persons2 = {new Person("zhangfei",15,"beijing","china"),new Person("zhaoyun",18,"shanghai","china")};
                stream = Arrays.stream(persons2);
                break;
            case 9:
                // 产生stream包含0到10
                IntStream.range(0, 10);
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
                         .mapToInt(m -> m.getValue()) // 转换每项为数值的新流
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
          new Person("zhangfei",15,"beijing","china"),
                new Person("xiangyu",35,"chongqing","china"),
                new Person("liubei",20,"shenzhen","china"),
                new Person("zhugeliang",25,"guangzhou","china"),
                new Person("liubei",20,"shenzhen","china"),
                new Person("guanyu",30,"hangzhou","china"),
                new Person("guanyu",30,"hangzhou","china"),
                new Person("zhaoyun",18,"shanghai","china"),
                new Person("xuxian",40,"xian","china")
        );
    }


    static class Person {

        private String name;
        private int age;
        private String address;
        private String contry;

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

        public String getContry() {
            return contry;
        }

        public void setContry(String contry) {
            this.contry = contry;
        }

        public Person() {
        }

        public Person(String name, int age, String address, String contry) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.contry = contry;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", contry='" + contry + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) { return false;}
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name) &&
                    Objects.equals(address, person.address) &&
                    Objects.equals(contry, person.contry);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, address, contry);
        }
    }

    /*
    有多种方式生成 Stream Source：
    从 Collection 和数组 : Collection.stream(), Collection.parallelStream(), Arrays.stream(T array) or Stream.of()
    从 BufferedReader   : java.io.BufferedReader.lines()
    静态工厂             : java.util.stream.IntStream.range(), java.nio.file.Files.walk()
    自己构建             : java.util.Spliterator
    其它                : Random.ints(), BitSet.stream(), Pattern.splitAsStream(java.lang.CharSequence), JarFile.stream()
    */


}
