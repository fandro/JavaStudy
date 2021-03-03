package com.javacore.generic.settool;

import java.util.EnumSet;
import java.util.Set;

import static com.javacore.generic.settool.Watercolors.*;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-02
 */
public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + Sets.union(set1, set2));
        Set<Watercolors> subset = Sets.intersection(set1, set2);
        System.out.println("intersection(set1, set2): " + subset);
        System.out.println("difference(set1, subset): " + Sets.difference(set1, subset));
        System.out.println("difference(set2, subset): " + Sets.difference(set2, subset));
        System.out.println("complement(set1, set2): " + Sets.complement(set1, set2));
    }
}
