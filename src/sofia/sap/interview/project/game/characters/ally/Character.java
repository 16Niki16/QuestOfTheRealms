package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

import java.util.HashSet;
import java.util.Set;

public class Character {
    private final String name;
    private final AllyCharacterType type;
    private final CharacterStatistics characterStats;
    private final Inventory inventory;
    private final Set<ItemType> equipableItems;

    public Character(String name, AllyCharacterType type) {
        this.name = name;
        this.type = type;
        this.characterStats = new CharacterStatistics(type);
        this.inventory = new Inventory();
        this.equipableItems = new HashSet<>();
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

    public void applyPotion(ItemType item) {
        int potionEffect = item.getEffect();

        switch (item) {
            case HEALING_HERB -> this.characterStats.increaseHealth(potionEffect);
            case MANA_POTION -> this.characterStats.increaseMana(potionEffect);
        }
    }

    public void equipItem(ItemType item) {
        if (this.equipableItems.contains(item)) {
            throw new ItemTypeAlreadyEquippedException("This kind of item is already equipped by the ally character!");
        }

        ItemType equipItem = this.inventory.getItem(item);
        this.equipableItems.add(equipItem);
        this.characterStats.increaseAttackRange(item);
    }

    public void unequipItem(ItemType item) {
        if (!this.equipableItems.contains(item)) {
            throw new EquipmentNotEquippedException("The provided equipment is not equipped!");
        }
        this.inventory.addItem(item);
        this.equipableItems.remove(item);
        this.characterStats.decreaseDamage(item);
    }
}
