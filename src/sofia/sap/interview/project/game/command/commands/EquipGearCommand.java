package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameContext;
import sofia.sap.interview.project.game.items.ItemType;

public class EquipGearCommand implements Command {
    private final GameContext context;
    private final ItemType gear;

    public EquipGearCommand(GameContext context, ItemType gear) {
        this.context = context;
        this.gear = gear;
    }

    @Override
    public CommandResult execute() {
        return this.context.combat().equip(this.context.character(), this.gear);
    }
}
