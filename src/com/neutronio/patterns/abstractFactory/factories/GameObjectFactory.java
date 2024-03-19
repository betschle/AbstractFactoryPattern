package com.neutronio.patterns.abstractFactory.factories;

import com.neutronio.patterns.abstractFactory.data.ItemProperties;
import com.neutronio.patterns.abstractFactory.gameobjects.Item;

import java.util.HashMap;

/**
 * Implementation of a two-level Game Object Factory that deals with creation items and its subclasses,
 * but can be easily extended to handle other complex objects, e.g. Vehicles.
 *
 * <p>The general idea of this specific Factory pattern design is that the presence of a
 * certain Construction Object defines what type of Game Object is being created:</p>
 * <ul>
 *         <li>ResourceProperties creates a Resource</li>
 *         <li>WeaponProperties creates a Weapon</li>
 *         <li>YourObjectProperties creates a YourObject</li>
 *         <li>no defined Object creates a simple Item without functionality</li>
 *         <li>etc.</li>
 *</ul>
 * <p>As long you stick to this rule, this pattern will serve you fairly well.</p>
 * <h1>Potential Extensions</h1>
 * <ul>
 *     <li>VehicleFactory, that creates working vehicles (cars, planes, tanks) with multiple subsystems (wheels, engine, seats...)</li>
 *     <li>WeaponFactory, if you have different types of weapons (melee, ranged) that also include many weapon mods</li>
 *     <li>MissionFactory, to create missions and mission objectives</li>
 *     <li>adding any procedural generation mechanisms</li>
 * </ul>
 * <h1>The Benefits</h1>
 * I've used a factory pattern like this in a few games, where it served me really well.
 * For an extensive network of objects that are complex it helps greatly with implementation
 * by breaking them down into many smaller factories. This pattern provides a framework for almost infinite growth.
 * It is useful for any game or application.
 * <h1>The Catch</h1>
 * The system as it is implemented here does not allow for an easy merge of functionality, e.g. Weapons can also be resources. Theoretically, it is
 * possible to extend it by adapting the object model. Remove the inheritance currently present between Item and its subclasses. Instead, add another layer of abstraction,
 * where the structure of {@link Item} reflects {@link ItemProperties}, such that:
 * <pre>
 * class Item {
 *     Weapon weapon; // optional
 *     WeaponMagazine magazine; // optional
 *     Resource resource; // optional
 * }
 * </pre>
 * You wouldn't even have to change the ItemFactory itself, only how the GameObjectFactory deals with object creation.
 * But still, only do this if it is necessary for your use case.
 */
public class GameObjectFactory {

    public ItemFactory itemFactory = new ItemFactory();
    /*
       Recommendation:
       If you want to spawn these objects in a game world, consider creating an ActorFactory.
       An ActorFactory would create actors in a game world, using whatever framework or engine of your choice.
       In this case, Actors should be treated as generic containers that can contain any game object.
       ActorFactory thus makes use of GameObjectFactory
     */
    private HashMap<String, ItemProperties> itemDatabase = new HashMap<>();

    public GameObjectFactory () {

        // filling the factory with some dummy data here. These are usually obtained from a file or database
        ItemProperties itemProperties = ItemProperties.getItemProperties();
        ItemProperties resourceProperties = ItemProperties.getResourceProperties();
        ItemProperties weaponProperties = ItemProperties.getWeaponProperties();

        this.itemDatabase.put( itemProperties.id, itemProperties  );
        this.itemDatabase.put( resourceProperties.id, resourceProperties );
        this.itemDatabase.put( weaponProperties.id, weaponProperties );
    }

    /**
     * Factory method that outputs any of the Item subclasses.
     * @param id
     * @return
     */
    public Item createItem( String id) {
        ItemProperties itemProperties = this.itemDatabase.get(id);
        if( itemProperties == null) return null;

        if ( itemProperties.weaponProperties != null ) {
            return this.itemFactory.createWeapon(itemProperties);
        } else
        if ( itemProperties.resourceProperties != null ){
            return this.itemFactory.createResource(itemProperties);
        } else
        if ( itemProperties.magazineProperties != null ){
            // order is important here. If no weapon is specified, it only creates a magazine as item
            return this.itemFactory.createWeaponMagazine(itemProperties);
        } else {
            // no additional functionality is required, so this is a simple item
            return this.itemFactory.createGenericItem( itemProperties );
        }
    }
}
