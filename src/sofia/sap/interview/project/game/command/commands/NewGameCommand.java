package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.files.NewGame;
import sofia.sap.interview.project.game.map.Playground;

public class NewGameCommand implements Command {
    @Override
    public CommandResult execute() {
        Playground playground = NewGame.createPlayground();
    }
}
