package sofia.sap.interview.project.game.characters;

public enum Type {
    MAGE(80, 120, new AttackRange(10, 20)),
    WARRIOR(100, 100, new AttackRange(10, 30)),
    ROGUE(110, 90, new AttackRange(5, 20));
    private final int health;
    private final int mana;
    private final AttackRange attackRange;

    Type(int health, int mana, AttackRange attackRange) {
        this.health = health;
        this.mana = mana;
        this.attackRange = attackRange;
    }
}
