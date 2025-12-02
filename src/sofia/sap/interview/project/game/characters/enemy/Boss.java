package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.Type;

public class Boss extends Enemy {
    public Boss(Type type) {
        super(type);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The boss made %d damage!", damage);
    }
}
