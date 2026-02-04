package sofia.sap.interview.project.game.inventory.items;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.inventory.items.gear.IronDagger;
import sofia.sap.interview.project.game.inventory.items.potions.HealingHerb;
import sofia.sap.interview.project.game.inventory.items.potions.ManaPotion;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

public interface Collectable {
    int getEffect();

    ItemType getType();

    static Collectable createItem(String itemName) {
        switch (itemName) {
            case "Iron dagger" -> new IronDagger();
            case "Healing herb" -> new HealingHerb();
            case "Mana potion" -> new ManaPotion();
            default -> throw new ItemNotAvailableException("The provided item type is not available!");
        }
        return null;
    }
}
