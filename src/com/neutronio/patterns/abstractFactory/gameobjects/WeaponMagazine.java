package com.neutronio.patterns.abstractFactory.gameobjects;
/**
 * A handgun magazine that is used by weapons.
 *
 * <p>This class determines behavior, while ItemProperties the parameters of its behavior.</p>
 * If you want to add a Weapon Mod that changes magazine capacity, this is the place.
 */
public class WeaponMagazine extends Item {
    public int maxBulletCount = 30;
}
