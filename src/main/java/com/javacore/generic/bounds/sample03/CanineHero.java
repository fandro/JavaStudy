package com.javacore.generic.bounds.sample03;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class CanineHero<POWER extends SuperHearing & SuperSmell>
        extends SuperHero<POWER> {

    CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}
