package com.neutronio.patterns.abstractFactory.data;
/**
 * A component that stores Item information. This object should be considered read-only and is originally
 * obtained from a file or database.
 * <p>
 * There are two approaches item systems can be implemented,
 * one is through Inheritance, the other via Composition. In modern
 * software development, Composition should be chosen over inheritance for a well-designed system.
 * </p>
 * This implementation here is a component approach, where we add an WeaponProperties instance where we need item functionality. *
 * Behavior is defined in respective game object class, or alternatively, a handler class.
 */
public class WeaponProperties {
    /** Important for data storage */
    public String id;
    public float fireRate;
    public float damage;

    // if you notice you're adding more and more constructors,
    // use a Builder Pattern to avoid constructor hell
    public WeaponProperties(float fireRate, float damage) {
        this.fireRate = fireRate;
        this.damage = damage;
    }
}
