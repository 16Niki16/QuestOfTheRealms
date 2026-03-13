package sofia.sap.interview.project.game.gameplay;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sofia.sap.interview.project.game.characters.ally.Character;

public record GameSession(Gameplay gameplay, Character character, @JsonIgnore CombatService combat, GameState state) {
}
