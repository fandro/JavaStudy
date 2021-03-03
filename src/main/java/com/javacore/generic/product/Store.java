package com.javacore.generic.product;

import java.util.ArrayList;

/**
 * 仓库，
 * 包含关系：仓库store包含过道Aisle，过道Aisle包含货架Shelf，货架Shelf包含商品product.
 *
 * @author fuwb
 * @since 2020-06-02
 */
public class Store extends ArrayList<Aisle> {
    // 收银台
    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();

    // 咖啡
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(5, 4, 3));
    }
}
