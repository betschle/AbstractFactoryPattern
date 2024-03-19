package com.neutronio.patterns.abstractFactory;

import com.neutronio.patterns.abstractFactory.factories.GameObjectFactory;
import com.neutronio.patterns.abstractFactory.gameobjects.Weapon;

/**
 * Testing out the GameObjectFactory pattern. Run this class for a test.
 *
 * To avoid boilerplate code, most fields are set to public in this project.
 */
public class Main {

    public static void main( String[] args) {
        // let's create a GameObject factory and try to create a weapon from it
        // with a few changes you can turn this easily into an automated test
        GameObjectFactory gameObjectFactory = new GameObjectFactory();
        Object rifle = gameObjectFactory.createItem("weapon_rifle");
        if( rifle instanceof Weapon) {
            Weapon assaultRifle = (Weapon) rifle; // feel free to set up a breakpoint here and explore in debug mode
            System.out.println("Weapon was created successfully!");
            System.out.println("Its max bullet count is: " + assaultRifle.magazine.maxBulletCount);
        } else {
            throw new RuntimeException("A Weapon was expected. What did you change??");
        }
    }
}
