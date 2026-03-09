package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.dto.events.NewGameDTO;

public record NewGameEvent(NewGameDTO newGame) implements GameEvent {
}
