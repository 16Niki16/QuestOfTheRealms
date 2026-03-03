package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;

public class HelpCommand implements Command {
    @Override
    public CommandResult<String> execute() {
        return CommandResult.withObject("""
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
