package com.neutronio.patterns.abstractFactory.gameobjects;

import com.neutronio.patterns.abstractFactory.data.ItemProperties;

/**
 * <p>This class mostly exists for documentation purpose (as structure also documents functionality).
 * Structurally spoken, this class is a container. Functionally, it represents a simple item without a function.
 * The Item itself does not possess any logic. Any logic or behavior is determined in its subclasses
 * (this is where this example does not adhere to the "composition over inheritance" principle).
 * Avoid adding logic in here.</p>
 *
 * The only thing that could be added here (without creating spaghetti code) is a currentStackSize
 * for inventory management.
 *
 * Any Trading logic should be moved to a sort of TradeHandler that uses two Inventories.
 * This sort of logic does not belong here. Break down problems in really small chunks and keep it simple!
 */
public class Item {

    public ItemProperties itemProperties;

}
