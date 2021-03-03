package com.javacore.generic.wildcard;

import java.util.HashMap;
import java.util.Map;

/**
 * 无界通配符02。
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class UnboundedWildcards2 {
    static Map map1;
    static Map<?,?> map2;
    static Map<String,?> map3;

    static void assign1(Map map) {
        map1 = map;
    }

    static void assign2(Map<?,?> map) {
        map2 = map;
    }

    static void assign3(Map<String,?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        //- assign3(new HashMap());
        // warning: [unchecked] unchecked method invocation:
        // method assign3 in class UnboundedWildcards2
        // is applied to given types
        //     assign3(new HashMap());
        //            ^
        //   required: Map<String,?>
        //   found: HashMap
        // warning: [unchecked] unchecked conversion
        //     assign3(new HashMap());
        //             ^
        //   required: Map<String,?>
        //   found:    HashMap
        // 2 warnings
        assign1(new HashMap<>());
        assign2(new HashMap<>());
        assign3(new HashMap<>());
    }
}
