package sofia.sap.interview.project.game.dto.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record InteractionDTO(String characterName, int damage, EnemyType type) {
    public static InteractionDTO from(Character character, int damage, Enemy enemy) {
        return new InteractionDTO(character.getCharacterName(), damage, enemy.getType());
    }
}
