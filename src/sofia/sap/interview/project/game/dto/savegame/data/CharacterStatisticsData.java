package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.characters.attack.AttackRange;

public class CharacterStatisticsData {
    private int health;
    private int mana;
    private AttackRange attackRange;

    public AttackRange getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(AttackRange attackRange) {
        this.attackRange = attackRange;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
