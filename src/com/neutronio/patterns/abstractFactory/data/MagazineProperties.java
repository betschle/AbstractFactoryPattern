package com.neutronio.patterns.abstractFactory.data;
/**
 * A component that stores Weapon Magazine information. This object should be considered read-only and is originally
 * obtained from a file or database.
 * <p>
 * There are two approaches item systems can be implemented,
 * one is through Inheritance, the other via Composition. In modern
 * software development, Composition should be chosen over inheritance for a well-designed system.
 * </p>
 * This implementation here is a composition approach, where we add an MagazineProperties instance where we need magazine functionality.
 * Behavior is defined in respective game object class, or alternatively, a handler class.
 *
 */
public class MagazineProperties {
    // potential extensions: AmmoType
    public int bulletCount = 30;

    public MagazineProperties(int bulletCount) {
        this.bulletCount = bulletCount;
    }
}
