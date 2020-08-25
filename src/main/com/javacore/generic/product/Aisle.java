package javacore.generic.product;

import java.util.ArrayList;

/**
 * 仓库中过道.
 *
 * @author fuwb
 * @date 2020-06-02
 */
public class Aisle extends ArrayList<Shelf> {

    Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}
