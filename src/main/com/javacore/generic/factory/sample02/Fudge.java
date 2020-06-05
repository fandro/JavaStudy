package javacore.generic.factory.sample02;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class Fudge {
    private static int count = 1;
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge " + n;
    }
}
