package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.inventory.Chest;

public class OpenChestCommand implements Command {
    private final GameContext context;

    public OpenChestCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Chest chest = this.context.gameplay().getChestOnCharacterCoordinates();

        if (chest == null) {
            throw new ChestNotAvailableException("There isn't a chest in this room!");
        }

        this.context.character().collectItems(chest);
        return new CommandResult(successfulCollectionMessage());
    }

    private String successfulCollectionMessage() {
        return "The items in the chest have been successfully collected!";
    }
}
