package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.DefendCommand;
import sofia.sap.interview.project.game.command.commands.EquipGearCommand;
import sofia.sap.interview.project.game.command.commands.HelpCommand;
import sofia.sap.interview.project.game.command.commands.LookCommand;
import sofia.sap.interview.project.game.command.commands.MoveCommand;
import sofia.sap.interview.project.game.command.commands.UnequipGearCommand;
import sofia.sap.interview.project.game.command.commands.UseItemCommand;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.user.User;

public class CommandFactory {
    /***
     * place to create the command, depends on client input??
     *
     */
    public static Command createCommand(String input, User user) {
        String[] commandSplit = input.split(" ", 2);

        String command = commandSplit[0].toLowerCase();
        CommandOptions option = CommandOptions.getOption(command);
        return switch (option) {
            case ATTACK -> new AttackCommand(user);
            case DEFEND -> new DefendCommand(user);
            case USE_ITEM -> new UseItemCommand(user, itemType(commandSplit[1]));
            case MOVE -> new MoveCommand(user, Direction.getDirection(commandSplit[1]));
            case LOOK -> new LookCommand(user);
            case EQUIP -> new EquipGearCommand(user, itemType(commandSplit[1]));
            case UNEQUIP -> new UnequipGearCommand(user, itemType(commandSplit[1]));
            case HELP -> new HelpCommand();
        };
    }

    private static ItemType itemType(String itemName) {
        return ItemType.getByName(itemName);
    }
}
