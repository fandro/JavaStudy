package javacore.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * WillNotCompile。
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class NonCovariantGenerics {
    // Compile Error: incompatible types:
    //List<Fruit> flist = new ArrayList<Apple>();

}
