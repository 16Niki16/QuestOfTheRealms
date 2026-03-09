package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.NewGameEvent;
import sofia.sap.interview.project.game.user.User;

public class NewGameCommand implements Command {
    private final User user;
    private final String name;
    private final AllyCharacterType type;

    public NewGameCommand(User user, String name, AllyCharacterType type) {
        this.user = user;
        this.name = name;
        this.type = type;
    }

    @Override
    public CommandResult execute() {
        this.user.createNewGame(name, type);
        return new EventResult(new NewGameEvent(NewGameDTO.create(this.user.getSession().character())));
    }
}
