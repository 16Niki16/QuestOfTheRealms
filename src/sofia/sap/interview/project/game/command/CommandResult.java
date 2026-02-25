package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.events.GameEvent;

public record CommandResult(String resultMessage, GameEvent event) {
    public static CommandResult withoutEvent(String resultMessage) {
        return new CommandResult(resultMessage, null);
    }

    public static CommandResult withEvent(String resultMessage, GameEvent event) {
        return new CommandResult(resultMessage, event);
    }
}
