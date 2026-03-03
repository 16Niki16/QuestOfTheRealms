package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record CharacterDamagedEvent(String characterName, int damage, EnemyType type) implements GameEvent {
    public static CharacterDamagedEvent characterDefendEvent(Character character, int damage, Enemy enemy) {
        return new CharacterDamagedEvent(character.getCharacterName(), damage, enemy.getType());
    }
}
