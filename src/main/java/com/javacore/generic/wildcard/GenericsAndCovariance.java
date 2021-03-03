package com.javacore.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        // List 必须持有一种具体的 Fruit 或 Fruit 的子类型
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<>();
        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        //flist.add(null); // Legal but uninteresting
        // We know it returns at least Fruit:
        Fruit f = flist.get(0);
    }

}
