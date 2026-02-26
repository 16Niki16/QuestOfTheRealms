package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.Consumable;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Character {
    private final String name;
    private final AllyCharacterType type;
    private final CharacterStatistics characterStats;
    private final Inventory inventory;
    private final Set<ItemType> equippedItems;

    public Character(String name, AllyCharacterType type) {
        this.name = name;
        this.type = type;
        this.characterStats = new CharacterStatistics(type);
        this.inventory = new Inventory();
        this.equippedItems = new HashSet<>();
    }

    public String getCharacterName() {
        return this.name;
    }

    public AllyCharacterType getCharacterType() {
        return this.type;
    }

    public int attackEnemy() {
        return this.characterStats.attackEnemy();
    }

    public boolean defendAgainstEnemy(int damage) {
        return this.characterStats.decreaseHealth(damage);
    }

    public void applyPotion(ItemType itemType) {
        Item item = inventory.getItem(itemType);

        if (!(item instanceof Consumable consumable)) {
            throw new ItemNotAvailableException("The provided item is not consumable!");
        }

        this.inventory.removeItem(itemType);
        consumable.consume(this);
    }

    public void equipGear(ItemType itemType) {
        Item item = inventory.getItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        } else if (this.equippedItems.contains(itemType)) {
            throw new ItemTypeAlreadyEquippedException("This kind of item is already equipped by the ally character!");
        }

        this.equippedItems.add(itemType);
        this.inventory.removeItem(itemType);
        gear.equip(this);
    }

    public void unequipGear(ItemType itemType) {
        Item item = ItemFactory.create(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        } else if (!this.equippedItems.contains(itemType)) {
            throw new EquipmentNotEquippedException("The provided item is not equipped!");
        }

        this.equippedItems.remove(itemType);
        this.inventory.addItem(itemType);
        gear.unequip(this);
    }

    public void collectItems(Chest chest) {
        Collection<Item> items = chest.collectItems();
        this.inventory.addAllItems(items);
    }

    public void heal(int amount) {
        this.characterStats.increaseHealth(amount);
    }

    public void restoreMana(int amount) {
        this.characterStats.increaseMana(amount);
    }

    public void increaseAttackDamage(int amount) {
        this.characterStats.increaseAttackRange(amount);
    }

    public void decreaseAttackDamage(int amount) {
        this.characterStats.decreaseDamage(amount);
    }
}
