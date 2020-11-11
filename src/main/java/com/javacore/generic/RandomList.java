package com.javacore.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 调用select(),随机返回集合中的一个元素。
 *
 * @author fuwb
 * @date 2020-06-01
 */
public class RandomList<T> extends ArrayList<T> {
    private Random rand = new Random(47);

    public T select() {
        return get(rand.nextInt(super.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        final String[] strings = "The quick brown fox jumped over the lazy brown dog".split(" ");
        Arrays.stream(strings).forEach(randomList::add);
        IntStream.range(0, 11).forEach(i -> {
            System.out.println(randomList.select());
        });
    }
}
