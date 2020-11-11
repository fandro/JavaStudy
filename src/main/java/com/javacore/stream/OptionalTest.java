package com.javacore.stream;

/**
 * Optional
 * <pre>
 *  常用方法：
 *   isPresent() : 判断是否为空，不建议使用
 *         get() ：获取对象，如果是null则报异常
 *  public<U> Optional<U> map(Function<? super T, ? extends U> mapper) :
 *  orElse(T other) :
 *  orElseGet(Supplier<? extends T> other) : 否则获取对象
 *  filter : 过滤
 *  flatMap : 集合二维转一维
 *  orElseThrow : 否则抛出异常
 * </pre>
 *
 * @author feako
 * @date 2018/4/27
 */
public class OptionalTest {
}
