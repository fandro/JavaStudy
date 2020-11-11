package com.javacore.generic.product;

import java.util.Random;
import java.util.function.Supplier;

/**
 * 产品信息.
 *
 * @author fuwb
 * @date 2020-06-02
 */
public class Product {

    private final int id;
    private String description;
    private double price;

    Product(int idNumber, String descr, double price) {
        id = idNumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description +
                ", price: $" + price;
    }

    public void priceChange(double change) {
        price += change;
    }

    /**
     *
     */
    public static Supplier<Product> generator =
            new Supplier<Product>() {
                private Random rand = new Random(47);

                /**
                 * 每次随机产生一个product。
                 * @return
                 */
                @Override
                public Product get() {
                    return new Product(rand.nextInt(1000), "Test",
                            Math.round(
                                    rand.nextDouble() * 1000.0) + 0.99);
                }
            };
}
