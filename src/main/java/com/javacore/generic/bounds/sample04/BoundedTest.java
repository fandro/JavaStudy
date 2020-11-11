package com.javacore.generic.bounds.sample04;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class BoundedTest {

    public void test() {
        //--------------  上界 -----------------------------
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
        // 不能存入任何元素，编译器只知道是Fruit或Fruit子类，无法确定是哪个具体类型，所以不允许插入
        //p.set(new Fruit()); //Error
        //p.set(new Apple()); //Error

        // 读取出来的东西只能存在Fruit或Fruit的父类里，读取值放在上界类，隐式转换为父类。
        Fruit newFruit1 = p.get();
        Object newFruit2 = p.get();
        //Apple newFruit3 = p.get();  //Error

        //--------------- 下界  ----------------------------
        Plate<? super Fruit> p2 = new Plate<Fruit>(new Fruit());
        // 存入元素正常，存入Fruit或其子类都是可以，因为Fruit子类可以隐式转换为Fruit。
        p2.set(new Fruit());
        p2.set(new Apple());

        // 读取出来的东西只能存放在Object(上界)里，读取值放在上界类，隐式转换为父类。
        //Apple apple = p2.get(); //Error
        //Fruit fruit = p2.get(); //Error
        Object object = p2.get();

        //-------------------------------------------
        // PECS (Producer Extends Consumer Super)
        // 频繁往外读取内容，适用于上界 extends
        // 经常往里插入的，适合用下界Super
    }

    // Leve1 - 食物
    public class Food { }

    // Level2 - 水果和肉
    public class Fruit extends Food{ }
    public class Meat extends Food{ }

    // Level3
    public class Apple extends Fruit{ }
    public class Banana extends Fruit{ }

    public class Pork extends Meat{ }
    public class Beef extends Meat{ }

    // Level 4
    class RedApple extends Apple { }
    class GreenApple extends Apple { }

    public class Plate<T> {

        private T item;

        public Plate(T t) {
            item=t;
        }

        public void set(T t){
            item=t;
        }

        public T get() {
            return item;
        }
    }
}
