package sofia.sap.interview.project.game.characters.ally;

import sofia.sap.interview.project.game.characters.ally.type.Type;
import sofia.sap.interview.project.game.exceptions.CharacterDeathException;

public class CharacterStatistics {
    private static final int MAX_STAT = 100;
    private static final int MIN_STAT = 0;
    private int health;
    private int mana;

    public CharacterStatistics(Type type) {
        this.health = type.getHealth();
        this.mana = type.getMana();
    }

    public void decreaseMana(int amount) {
        if (this.mana - amount < MIN_STAT) {
            this.mana = MIN_STAT;
        } else {
            this.mana -= amount;
        }
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;

        if (this.health <= MIN_STAT) {
            throw new CharacterDeathException("Character health dead");
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
}
