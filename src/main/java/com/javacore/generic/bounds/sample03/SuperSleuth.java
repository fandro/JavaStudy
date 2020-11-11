package com.javacore.generic.bounds.sample03;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {

    SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}
