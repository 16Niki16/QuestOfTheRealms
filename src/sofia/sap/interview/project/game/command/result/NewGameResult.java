package sofia.sap.interview.project.game.command.result;

import sofia.sap.interview.project.game.gameplay.GameSession;

public record NewGameResult(GameSession session) implements CommandResult {
}
