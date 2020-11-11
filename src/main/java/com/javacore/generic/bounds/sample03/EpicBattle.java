package com.javacore.generic.bounds.sample03;

import java.util.List;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class EpicBattle {

    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogPerson dogPerson = new DogPerson();
        useSuperHearing(dogPerson);
        superFind(dogPerson);
        // You can do this:
        List<? extends SuperHearing> audioPeople;
        // But you can't do this:
        // List<? extends SuperHearing & SuperSmell> dogPs;
    }
}
