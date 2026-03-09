package sofia.sap.interview.project.game.dto.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.attack.AttackRange;

public record NewGameDTO(String characterName, AllyCharacterType type, int health, int mana, AttackRange range) {
    public static NewGameDTO from(Character character) {
        CharacterStatistics stats = character.getCharacterStats();
        return new NewGameDTO(character.getCharacterName(), character.getCharacterType(),
                stats.getHealth(), stats.getMana(), stats.getAttackRange());
    }
}
