package javacore.generic.templatemethod;

/**
 * GenericWithCreate 包含 element 字段，并通过无参构造函数强制其初始化，
 * 该构造函数又调用抽象的 create() 方法。这种创建方式可以在子类中定义，同时建立 T 的类型。
 *
 * @author fuwb
 * @date 2020-06-03
 */
abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        this.element = create();
    }

    abstract T create();
}
