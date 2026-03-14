package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;

public record GameSession(Gameplay gameplay, Character character, CombatService combat, GameState state) {
    public static GameSession load(Gameplay gameplay, Character character) {
        if (character.isCharacterDead()) {
            return new GameSession(gameplay, character, new CombatService(), GameState.GAME_OVER);
        }
        return new GameSession(gameplay, character, new CombatService(), GameState.RUNNING);
    }
}
