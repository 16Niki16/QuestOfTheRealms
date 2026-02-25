package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.Consumable;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.Collection;
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

    public AllyCharacterType getCharacterType() {
        return this.type;
    }

    public void attackEnemy(Enemy enemy) {
        int damage = this.characterStats.attackEnemy();
        enemy.defendAgainstAllyCharacter(damage);
    }

    public void defendAgainstEnemy(int damage) {
        this.characterStats.decreaseHealth(damage);
    }

    public void applyPotion(Consumable item) {
        this.inventory.removeItem(item);
        item.consume(this);
    }

    public void equipGear(Gear gear) {
        if (this.equippedItems.contains(gear) || !this.inventory.checkItemInInventory(gear)) {
            throw new ItemTypeAlreadyEquippedException("This kind of item is already equipped by the ally character!");
        }

        this.equippedItems.add(gear);
        this.inventory.removeItem(gear);
        gear.equip(this);
    }

    public void unequipGear(Gear gear) {
        if (!this.equippedItems.contains(gear)) {
            throw new EquipmentNotEquippedException("The provided item is not equipped!");
        }
        this.equippedItems.remove(gear);
        this.inventory.addItem(gear);
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
