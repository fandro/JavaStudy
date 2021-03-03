package com.javacore.generic.basicsupplier;

import java.util.function.Supplier;

/**
 * 泛型的 Supplier.
 * <pre>
 *  作用：传入类名参数生成类.
 *  此类提供了产生以下对象的基本实现：
 *  1. 是 public 的。 因为 BasicSupplier 在单独的包中，
 *  所以相关的类必须具有 public 权限，而不仅仅是包级访问权限。
 *  2. 具有无参构造方法。要创建一个这样的 BasicSupplier 对象，请调用 create() 方法，
 *  并将要生成类型的类型令牌传递给它。通用的 create() 方法提供了 BasicSupplier.create(MyType.class) 这种较简洁的语法来代替
 *  较笨拙的 new BasicSupplier <MyType>(MyType.class)。
 *  参考 https://lingcoder.gitee.io/onjava8/#/book/20-Generics?id=%e4%b8%80%e4%b8%aa%e6%b3%9b%e5%9e%8b%e7%9a%84-supplier
 * </pre>
 *
 * @author fuwb
 * @since 2020-06-02
 */
public class BasicSupplier<T> implements Supplier<T> {

    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}
