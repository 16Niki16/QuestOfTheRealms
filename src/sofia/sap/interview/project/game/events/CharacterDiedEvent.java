package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;

public record CharacterDiedEvent(Character character) implements GameEvent {
}
