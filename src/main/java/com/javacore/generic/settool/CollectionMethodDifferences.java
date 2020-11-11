package com.javacore.generic.settool;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-02
 */
public class CollectionMethodDifferences {

    /**
     * 读取方法名。
     * @param type
     * @return
     */
    static Set<String> methodSet(Class<?> type) {
        // 读取类中的所有方法名称。
        return Arrays.stream(type.getMethods())
                .map(Method::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * 读取类实现的接口。
     * @param type
     */
    static void interfaces(Class<?> type) {
        System.out.println("Interfaces in " + type.getSimpleName() + ": ");
        System.out.println(
                Arrays.stream(type.getInterfaces())
                .map(Class::getSimpleName)
                .collect(Collectors.toList()));
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() +
                " extends " + subset.getSimpleName() + ", adds: ");

        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);

        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));

        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);
        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
}
