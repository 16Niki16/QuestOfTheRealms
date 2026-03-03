package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.map.room.Room;

public record CharacterMovedEvent(String characterName, String roomName) implements GameEvent {
    public static CharacterMovedEvent movedEvent(Character character, Room room) {
        return new CharacterMovedEvent(character.getCharacterName(), room.getName());
    }
}
