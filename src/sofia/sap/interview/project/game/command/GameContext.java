package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.gameplay.Gameplay;

public record GameContext(Gameplay gameplay, Character character) {
}
