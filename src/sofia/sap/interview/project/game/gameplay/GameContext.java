package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.gameplay.CombatActions;
import sofia.sap.interview.project.game.gameplay.Gameplay;
import sofia.sap.interview.project.game.quests.QuestLog;

public record GameContext(Gameplay gameplay, Character character, QuestLog log, CombatActions combat, GameState state) {
}
