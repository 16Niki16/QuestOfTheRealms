package sofia.sap.interview.project.game.characters.ally.statistics;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.attack.AttackRange;

import java.util.concurrent.ThreadLocalRandom;

public class CharacterStatistics extends BaseStatistics {
    private int mana;

    public CharacterStatistics(AllyCharacterType type) {
        super(type.getHealth(), type.getAttackRange());
        this.mana = type.getMana();
    }

    public CharacterStatistics(int health, AttackRange attackRange, int mana) {
        super(health, attackRange);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public boolean decreaseMana(int amount) {
        if (this.mana - amount < MIN_STAT) {
            return false;
        }

        this.mana -= amount;
        return true;
    }

    public void increaseMana(int amount) {
        this.mana += amount;

        if (this.mana > MAX_STAT) {
            this.mana = MAX_STAT;
        }
    }

    @Override
    public int attack() {
        boolean enoughMana = decreaseMana(getAttackRange().manaCost());
        if (enoughMana) {
            return ThreadLocalRandom.current().nextInt(getAttackRange().minDamage(), getAttackRange().maxDamage() + 1);
        }
        return 0;
    }

    public void increaseAttackRange(int amount) {
        int minDamage = this.getAttackRange().minDamage() + amount;
        int maxDamage = this.getAttackRange().maxDamage() + amount;

        setAttackRange(new AttackRange(minDamage, maxDamage, getAttackRange().manaCost()));
    }

    public void decreaseAttackRange(int amount) {
        int min = Math.max(0, getAttackRange().minDamage() - amount);
        int max = Math.max(min, getAttackRange().maxDamage() - amount);

        setAttackRange(new AttackRange(min, max, getAttackRange().manaCost()));
    }
}
