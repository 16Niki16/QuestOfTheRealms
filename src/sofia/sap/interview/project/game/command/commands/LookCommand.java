package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.gameplay.RoomView;

public class LookCommand implements Command {
    private final GameSession context;

    public LookCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult<RoomView> execute() {
       /* Chest chest = this.context.gameplay().getChestOnCharacterCoordinates();
        Enemy enemy = this.context.gameplay().getEnemyOnCharacterCoordinates();
        SpecialItem specialItem = this.context.gameplay().getSpecialItemOnPlayerCoordinates();

        StringBuilder contain = new StringBuilder("The room contains:\n");
        if (chest != null) {
            contain.append("- Chest\n");
        }
        if (enemy != null) {
            contain.append("- Enemy: ");
            contain.append(enemy.getType().getName()).append("\n");
        }
        if (specialItem != null) {
            contain.append("-Special item: ");
            contain.append(specialItem.getName());
            return CommandResult.withEvent(contain.toString(), new CollectSpecialItemEvent(specialItem));
        }*/
        return CommandResult.withObject(this.context.gameplay().lookAround());
    }
}
