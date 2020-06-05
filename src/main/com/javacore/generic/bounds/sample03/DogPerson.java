package javacore.generic.bounds.sample03;

/**
 * TODO
 *
 * @author fuwb
 * @date 2020-06-03
 */
public class DogPerson extends CanineHero<SuperHearSmell>  {
    DogPerson() {
        super(new SuperHearSmell());
    }
}
