package com.neutronio.patterns.abstractFactory.factories;

import com.neutronio.patterns.abstractFactory.data.ItemProperties;
import com.neutronio.patterns.abstractFactory.gameobjects.Item;
import com.neutronio.patterns.abstractFactory.gameobjects.Resource;
import com.neutronio.patterns.abstractFactory.gameobjects.Weapon;
import com.neutronio.patterns.abstractFactory.gameobjects.WeaponMagazine;

/**
 * Deals with creation of Instances of {@link Item}. Used by {@link GameObjectFactory}
 */
public class ItemFactory {

    /**
     * Creates a weapon together with a magazine.
     * Both weaponProperties and magazineProperties must be defined
     * in order to successfully create a weapon.
     * @param itemProperties
     * @return a weapon with a fully loaded magazine
     */
    public Weapon createWeapon(ItemProperties itemProperties) {
        if( itemProperties.weaponProperties == null) return null;
        if( itemProperties.magazineProperties == null) return null;
        Weapon weapon = new Weapon();

        // assume the supplied magazine is to be used together with the weapon
        weapon.magazine = createWeaponMagazine( itemProperties );
        weapon.reload();

        // ...
        // add construction of other subsystems for weapons here. e.g. magazines, mods
        // the magazine is not properly adapted to this pattern yet. Challenge yourself and use this pattern!

        weapon.itemProperties = itemProperties;
        return weapon;
    }

    /**
     *
     * @param itemProperties
     * @return
     */
    public WeaponMagazine createWeaponMagazine(ItemProperties itemProperties) {
        if( itemProperties.magazineProperties == null) return null;
        WeaponMagazine weaponMagazine = new WeaponMagazine();
        weaponMagazine.maxBulletCount = itemProperties.magazineProperties.bulletCount;
        return weaponMagazine;
    }

    /**
     *
     * @param itemProperties
     * @return
     */
    public Resource createResource(ItemProperties itemProperties) {
        if( itemProperties.resourceProperties == null) return null;
        Resource resource = new Resource();
        resource.itemProperties = itemProperties;

        // ...
        // add construction of other potential subsystems for resource here

        return resource;
    }

    /**
     * Creates a generic item without any logic
     * @param itemProperties
     * @return
     */
    public Item createGenericItem(ItemProperties itemProperties) {
        Item item = new Item();
        item.itemProperties = itemProperties;
        return item;
    }
}
