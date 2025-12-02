package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.Type;

public class Bandit extends Enemy {

    public Bandit(Type type) {
        super(type);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The bandit made %d damage!", damage);
    }
}
