package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.quests.QuestLog;

public record GameSession(Gameplay gameplay, Character character, QuestLog log, CombatService combat, GameState state) {
}
