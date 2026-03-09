package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.command.commands.NewGameDTO;

public record NewGameEvent(NewGameDTO newGame) implements GameEvent {
}
