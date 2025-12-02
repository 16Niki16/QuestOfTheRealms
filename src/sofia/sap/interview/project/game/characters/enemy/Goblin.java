package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.Type;

public class Goblin extends Enemy {
    public Goblin(Type type) {
        super(type);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The goblin made %d damage!", damage);
    }

}
