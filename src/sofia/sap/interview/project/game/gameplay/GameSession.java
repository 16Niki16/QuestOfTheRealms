package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;

public record GameSession(Gameplay gameplay, Character character, CombatService combat) {
    public static GameSession load(Gameplay gameplay, Character character) {
        return new GameSession(gameplay, character, new CombatService());
    }
}
