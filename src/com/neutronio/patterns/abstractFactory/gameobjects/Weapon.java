package com.neutronio.patterns.abstractFactory.gameobjects;

import com.neutronio.patterns.abstractFactory.data.ItemProperties;

/**
 * A weapon that can be used by Player and Enemies.
 *
 * <p>This class determines behavior on this object, while ItemProperties the parameters of its behavior.</p>
 */
public class Weapon extends Item {

    public WeaponMagazine magazine;

    private int currentBulletCount;

    public boolean canFire() {
        if( this.currentBulletCount == 0) return false;
        return true;
    }
    /**
     *
     * @return true if weapon could be fired
     */
    public boolean fire() {
        // Add your fire code here that directly affects this class
        if( canFire() ) {
            this.currentBulletCount = this.currentBulletCount - 1;
        }
        return false;

        // Recommendation: A FiringManager should use Weapon and determine in which interval a bullet is fired
        // With such a class you can also implement different fire modes
    }

    /**
     *
     * @return the amount of bullets that were inside the magazine before reloading.
     */
    public int reload() {
        int bulletsLeft = magazine.maxBulletCount - this.currentBulletCount;
        this.currentBulletCount = magazine.maxBulletCount;
        return bulletsLeft;
    }
}
