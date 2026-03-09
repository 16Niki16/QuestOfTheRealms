package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.dto.events.NewGameDTO;
import sofia.sap.interview.project.game.events.NewGameEvent;
import sofia.sap.interview.project.game.user.User;

public class NewGameCommand implements Command {
    private final String name;
    private final AllyCharacterType type;

    public NewGameCommand(String name, AllyCharacterType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public CommandResult execute(User user) {
        user.createNewGame(name, type);
        return new EventResult(new NewGameEvent(NewGameDTO.from(user.getSession().character())));
    }
}
