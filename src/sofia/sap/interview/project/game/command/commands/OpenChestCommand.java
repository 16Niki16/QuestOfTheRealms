package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.Collection;

public class OpenChestCommand implements Command {
    private final GameSession context;

    public OpenChestCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Chest chest = this.context.gameplay().getChestOnCharacterCoordinates();
        return this.context.combat().collect(this.context.character(), chest);
    }
}
