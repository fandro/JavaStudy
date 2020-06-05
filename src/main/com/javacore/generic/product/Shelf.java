package javacore.generic.product;

import javacore.generic.Suppliers;

import java.util.ArrayList;

/**
 * 仓库中的货架.
 *
 * @author fuwb
 * @date 2020-06-02
 */
public class Shelf extends ArrayList<Product> {
    /**
     * 构造方法中生成product实例。
     * @param nProducts
     */
    Shelf(int nProducts) {
        Suppliers.fill(this, Product.generator, nProducts);
    }
}
