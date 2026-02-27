package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.map.room.Chest;

public class OpenChestCommand implements Command {
    private final GameSession context;

    public OpenChestCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Chest chest = this.context.gameplay().getChestOnCharacterCoordinates();

        if (chest == null) {
            throw new ChestNotAvailableException("There isn't a chest in this room!");
        }

        this.context.character().collectItems(chest);
        return CommandResult.withoutEvent(successfulCollectionMessage());
    }

    private String successfulCollectionMessage() {
        return "The items in the chest have been successfully collected!";
    }
}
