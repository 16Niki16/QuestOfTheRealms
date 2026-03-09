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

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, CommandParser> parser = new HashMap<>();

    public CommandFactory() {
        parser.
    }

    public static Command createCommand(String input, User user) {
        String[] commandSplit = input.split(" ", 2);

        String command = commandSplit[0].toLowerCase();
        CommandOptions option = CommandOptions.getOption(command);
        return switch (option) {
            case ATTACK -> new AttackCommand();
            case DEFEND -> new DefendCommand();
            case USE_ITEM -> new UseItemCommand(itemType(commandSplit[1]));
            case MOVE -> new MoveCommand(Direction.getDirection(commandSplit[1]));
            case LOOK -> new LookCommand();
            case EQUIP -> new EquipGearCommand(itemType(commandSplit[1]));
            case UNEQUIP -> new UnequipGearCommand(itemType(commandSplit[1]));
            case HELP -> new HelpCommand();
        };
    }

    private static ItemType itemType(String itemName) {
        return ItemType.getByName(itemName);
    }
}
