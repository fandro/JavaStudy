package com.javacore.generic.templatemethod;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class XCreator  extends GenericWithCreate<X> {

    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
