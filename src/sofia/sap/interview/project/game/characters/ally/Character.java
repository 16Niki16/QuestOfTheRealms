package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
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

    public void applyHealingPotion() {
        ItemType healingPotion = inventory.getPotion(ItemType.HEALING_HERB);
        int potionEffect = healingPotion.getEffect();
        this.characterStats.increaseHealth(potionEffect);
    }

    public void applyManaPotion() {
        ItemType manaPotion = inventory.getPotion(ItemType.MANA_POTION);
        int potionEffect = manaPotion.getEffect();
        this.characterStats.increaseMana(potionEffect);
    }

    public void equipDagger() {
        if (this.equipableItems.contains(ItemType.IRON_DAGGER)) {
            throw new ItemTypeAlreadyEquippedException("This kind of item is already equipped by the ally character!");
        }

    }
}
