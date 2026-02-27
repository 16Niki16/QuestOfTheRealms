package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.events.GameEvent;

public record CommandResult<T>(String resultMessage, T obj, GameEvent event) {
    public static <T> CommandResult<T> messageResult(String resultMessage) {
        return new CommandResult<>(resultMessage, null, null);
    }

    public static <T> CommandResult<T> withObject(String resultMessage, T obj) {
        return new CommandResult<>(resultMessage, obj, null);
    }

    public static <T> CommandResult<T> withEvent(String resultMessage, T obj, GameEvent event) {
        return new CommandResult<>(resultMessage, obj, event);
    }
}
