package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.inventory.items.gear.Gear;
import sofia.sap.interview.project.game.inventory.items.potions.Potion;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

import java.util.HashSet;
import java.util.Set;

public class Character {
    private final String name;
    private final AllyCharacterType type;
    private final CharacterStatistics characterStats;
    private final Inventory inventory;
    private final Set<Gear> equippedItems;

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

    public int attackEnemy() {
        return this.characterStats.attackEnemy();
    }

    public void defendAgainstEnemy(int damage) {
        this.characterStats.decreaseHealth(damage);
    }

    public void applyPotion(Potion item) {
        item.applyPotion(this);
    }

    public void equipGear(Gear gear) {
        if (this.equippedItems.contains(gear) || this.inventory.) {
            throw new ItemTypeAlreadyEquippedException("This kind of item is already equipped by the ally character!");
        }
        gear.equipGear(this);
    }

    public void unequipGear(Gear gear) {

    }

    public void heal(int amount) {
        this.characterStats.increaseHealth(amount);
    }

    public void restoreMana(int amount) {
        this.characterStats.increaseMana(amount);
    }

    public void increaseAttackDamage(int amount) {

        ItemType equipItem = this.inventory.getItem(item);
        this.equippedItems.add(equipItem);
        this.characterStats.increaseAttackRange(item);
    }

    public void unequipItem(ItemType item) {
        if (!this.equippedItems.contains(item)) {
            throw new EquipmentNotEquippedException("The provided equipment is not equipped!");
        }
        this.inventory.addItem(item);
        this.equippedItems.remove(item);
        this.characterStats.decreaseDamage(item);
    }
}
