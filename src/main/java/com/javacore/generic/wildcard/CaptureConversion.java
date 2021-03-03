package com.javacore.generic.wildcard;

/**
 * <?>无界通配符的捕获转换。
 * 因为未指定的通配符类型被捕获，并被转换为确切类型
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class CaptureConversion {

    // 类型参数是确切的
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    // 无界通配符,类型是未知的
    static void f2(Holder<?> holder) {
        // 在调用 f2() 的过程中捕获了参数类型，并在调用 f1() 时使用了这种类型。
        f1(holder); // Call with captured type
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<>(1);
        f1(raw);
        // warning: [unchecked] unchecked method invocation:
        // method f1 in class CaptureConversion
        // is applied to given types
        //     f1(raw);
        //       ^
        //   required: Holder<T>
        //   found: Holder
        //   where T is a type-variable:
        //     T extends Object declared in
        //     method <T>f1(Holder<T>)
        // warning: [unchecked] unchecked conversion
        //     f1(raw);
        //        ^
        //   required: Holder<T>
        //   found:    Holder
        //   where T is a type-variable:
        //     T extends Object declared in
        //     method <T>f1(Holder<T>)
        // 2 warnings
        f2(raw); // No warnings

        Holder rawBasic = new Holder();
        rawBasic.set(new Object());
        // warning: [unchecked] unchecked call to set(T)
        // as a member of the raw type Holder
        //     rawBasic.set(new Object());
        //                 ^
        //   where T is a type-variable:
        //     T extends Object declared in class Holder
        // 1 warning
        f2(rawBasic); // No warnings

        // Upcast to Holder<?>, still figures it out:
        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
    }
}
