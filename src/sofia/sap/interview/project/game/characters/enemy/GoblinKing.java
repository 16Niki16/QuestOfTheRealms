package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class GoblinKing extends Enemy {
    public GoblinKing(EnemyType type) {
        super(type);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The goblin king attack caused %d damage!", damage);
    }
}
