package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;

public class EquipGearCommand implements Command {
    private final GameSession context;
    private final ItemType gear;

    public EquipGearCommand(GameSession context, ItemType gear) {
        this.context = context;
        this.gear = gear;
    }

    @Override
    public CommandResult<Void> execute() {
        return this.context.combat().equip(this.context.character(), this.gear);
    }
}
