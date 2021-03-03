package com.javacore.generic.GenericArray;

import java.lang.reflect.Array;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;
    // 类型参数传递到Class<T>中，新建T的数组
    public GenericArrayWithTypeToken(Class<T> type, int sz ) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        // This now works:
        Integer[] ia = gai.rep();
    }
}
