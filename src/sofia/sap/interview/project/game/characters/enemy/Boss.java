package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class Boss extends Enemy {
    public Boss(EnemyType type) {
        super(type);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The boss made %d damage!", damage);
    }
}
