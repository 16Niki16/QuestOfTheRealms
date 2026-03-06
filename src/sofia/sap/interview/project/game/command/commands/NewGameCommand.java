package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.NewGameResult;
import sofia.sap.interview.project.game.gameplay.GameSessionCreator;

public class NewGameCommand implements Command {
    private final String name;
    private final AllyCharacterType type;

    public NewGameCommand(String name, AllyCharacterType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public CommandResult execute() {
        return new NewGameResult(GameSessionCreator.newGame(name, type));
    }
}
