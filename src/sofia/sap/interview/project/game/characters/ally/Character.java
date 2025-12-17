package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.attack.AttackRange;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.inventory.items.type.ItemType;

import java.util.concurrent.ThreadLocalRandom;

public class Character {
    private final String name;
    private final AllyCharacterType type;
    private final CharacterStatistics characterStats;
    private final Inventory inventory;

    public Character(String name, AllyCharacterType type) {
        this.name = name;
        this.type = type;
        this.characterStats = new CharacterStatistics(type);
        this.inventory = new Inventory();
    }

    public String getCharacterName() {
        return this.name;
    }

    public int attackEnemy() {
        AttackRange range = type.getAttackRange();
        return ThreadLocalRandom.current().nextInt(range.minDamage(), range.maxDamage() + 1);
    }

    public void defendAgainstEnemy(int damage) {
        this.characterStats.decreaseHealth(damage);
    }

    public void applyHealingPotion() {
        ItemType healingPotion = inventory.getHealingPotion();
        int potionEffect = healingPotion.getEffect();
        this.characterStats.decreaseHealth(potionEffect);
    }
}
