package com.javacore.generic.bounds.sample03;

/**
 * TODO
 *
 * @author fuwb
 * @since 2020-06-03
 */
public class SuperHero<POWER extends SuperPower> {
    POWER power;

    SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower() {
        return power;
    }
}
