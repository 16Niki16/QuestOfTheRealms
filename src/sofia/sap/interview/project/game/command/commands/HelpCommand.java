package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;

public class HelpCommand implements Command {
    @Override
    public CommandResult execute() {
        return CommandResult.withoutEvent("""
                Available commands:
                - move [north | south | east | west]
                - look
                - attack
                - use [item]
                - inventory
                - equip [item]
                - unequip [item]
                - quests
                - completed quests
                - save
                - load
                - exit
                """);
    }
}
