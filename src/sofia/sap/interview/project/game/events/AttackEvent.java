package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record AttackEvent(EnemyType type, int damage, String characterName) implements GameEvent {
    public static AttackEvent damageEnemy(Enemy enemy, int damage, Character character) {
        return new AttackEvent(enemy.getType(), damage, character.getCharacterName());
    }
}
