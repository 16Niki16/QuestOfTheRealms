package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.attack.AttackRange;
import sofia.sap.interview.project.game.exceptions.CharacterDeathException;
import sofia.sap.interview.project.game.exceptions.NotEnoughManaException;

import java.util.concurrent.ThreadLocalRandom;

public class CharacterStatistics {
    private static final int MAX_STAT = 100;
    private static final int MIN_STAT = 0;
    private int health;
    private int mana;
    private AttackRange attackRange;

    public CharacterStatistics(AllyCharacterType type) {
        this.health = type.getHealth();
        this.mana = type.getMana();
        this.attackRange = type.getAttackRange();
    }

    public void decreaseMana(int amount) {
        if (this.mana - amount < MIN_STAT) {
            throw new NotEnoughManaException("The attack can not be executed, because the mana is not enough!");
        } else {
            this.mana -= amount;
        }
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;

        if (this.health <= MIN_STAT) {
            throw new CharacterDeathException("Your character died!");
        }

    }

    public void increaseMana(int amount) {
        this.mana += amount;

        if (this.mana > MAX_STAT) {
            this.mana = MAX_STAT;
        }
    }

    public void increaseHealth(int amount) {
        this.health += amount;

        if (this.health > MAX_STAT) {
            this.health = MAX_STAT;
        }
    }

    public int attackEnemy() {
        decreaseMana(attackRange.manaCost());
        return ThreadLocalRandom.current().nextInt(attackRange.minDamage(), attackRange.maxDamage() + 1);
    }

    public void increaseAttackRange(int amount) {
        int minDamage = this.attackRange.minDamage() + amount;
        int maxDamage = this.attackRange.maxDamage() + amount;

        this.attackRange = new AttackRange(minDamage, maxDamage, this.attackRange.manaCost());
    }

    public void decreaseDamage(int amount) {
        int minDamage = this.attackRange.minDamage() - amount;
        int maxDamage = this.attackRange.maxDamage() - amount;

        this.attackRange = new AttackRange(minDamage, maxDamage, this.attackRange.manaCost());
    }
}
