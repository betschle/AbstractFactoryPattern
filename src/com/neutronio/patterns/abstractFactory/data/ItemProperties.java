package com.neutronio.patterns.abstractFactory.data;

/**
 * A component that stores Item information. This object should be considered read-only and is originally
 * obtained from a file or database. It can be seen as "collective model" for an "individual instance".
 * <p>
 * There are two approaches item systems can be implemented,
 * one is through Inheritance, the other via Composition. In modern
 * software development, Composition should be chosen over inheritance for a well-designed system.
 * </p>
 * This implementation here is a composition approach, where we add an ItemProperties instance where we need item functionality.
 * Behavior is defined in respective game object class, or alternatively, a handler class.
 */
public class ItemProperties {
    /** Important for data storage */
    public String id;
    /** The name of the item */
    public String name;
    /** The value of the item, per unit */
    public int value;
    /** The weight of the item, per unit */
    public float weight;

    // ============ Additional Functionality ============

    /** Optional weapon properties.
     * If this object is not null, the item at hand is a weapon. */
    public WeaponProperties weaponProperties;
    /** Optional resource properties.
     * If this object is not null, the item at hand is a resource. */
    public ResourceProperties resourceProperties;
    /** Optional weapon magazine properties.
     * If this object is not null, the item at hand is a weapon magazine. */
    public MagazineProperties magazineProperties;

    // to extend functionality, e.g. for healing items, add EffectProperties and Effect
    // ============

    // if you notice you're adding more and more constructors,
    // use a Builder Pattern to avoid constructor hell
    public ItemProperties(String id, String name, int value, float weight) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    /*
     * The following methods are mockups. Usually, your item properties are stored
     * in a database or file somewhere. But this is not scope of this example
     */

    public static ItemProperties getWeaponProperties() {
        ItemProperties properties = new ItemProperties("weapon_rifle", "Assault Rifle", 23, 2.3f);
        properties.weaponProperties = new WeaponProperties(100f, 1.3f);
        properties.magazineProperties = new MagazineProperties(30);
        return properties;
    }

    public static ItemProperties getResourceProperties() {
        ItemProperties properties = new ItemProperties("resource_wood", "Wood", 1, 1.4f);
        properties.resourceProperties = new ResourceProperties();
        return properties;
    }

    public static ItemProperties getItemProperties() {
        return new ItemProperties("item_sandwich", "Sandwich", 23, 2.3f);
    }
}
