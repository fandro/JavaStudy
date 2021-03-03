package com.javacore.generic.wildcard;

/**
 * WillNotCompile。
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class NonCovariantGenerics {
    // Compile Error: incompatible types:
    //List<Fruit> flist = new ArrayList<Apple>();

}
