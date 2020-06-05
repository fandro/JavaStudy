package javacore.generic.bounds.sample01;

/**
 * Bounded继续Coord类，实现接口 HasColor，Weight。
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class Bounded extends Coord implements HasColor, Weight {

    @Override
    public java.awt.Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
