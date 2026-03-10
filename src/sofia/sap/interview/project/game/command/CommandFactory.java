package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.CheckQuestsCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.DefendCommand;
import sofia.sap.interview.project.game.command.commands.MoveCommand;
import sofia.sap.interview.project.game.command.commands.OpenChestCommand;
import sofia.sap.interview.project.game.command.commands.PathsCommand;
import sofia.sap.interview.project.game.command.commands.EquipGearCommand;
import sofia.sap.interview.project.game.command.commands.HelpCommand;
import sofia.sap.interview.project.game.command.commands.LookCommand;
import sofia.sap.interview.project.game.command.commands.UnequipGearCommand;
import sofia.sap.interview.project.game.command.commands.UseItemCommand;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.Direction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, CommandParser> COMMANDS = new HashMap<>();
    private static final Command HELP = new HelpCommand();
    private static final Command ATTACK = new AttackCommand();
    private static final Command QUESTS = new CheckQuestsCommand();
    private static final Command DEFEND = new DefendCommand();
    private static final Command LOOK = new LookCommand();
    private static final Command PATHS = new PathsCommand();
    private static final Command OPEN = new OpenChestCommand();

    public CommandFactory() {
        COMMANDS.put(CommandOptions.HELP.getCommand(), args -> HELP);
        COMMANDS.put(CommandOptions.ATTACK.getCommand(), args -> ATTACK);
        COMMANDS.put(CommandOptions.QUESTS.getCommand(), args -> QUESTS);
        COMMANDS.put(CommandOptions.LOOK.getCommand(), args -> LOOK);
        COMMANDS.put(CommandOptions.PATHS.getCommand(), args -> PATHS);
        COMMANDS.put(CommandOptions.OPEN.getCommand(), args -> OPEN);

        COMMANDS.put(CommandOptions.EQUIP.getCommand(), args -> new EquipGearCommand(itemType(args[0])));
        COMMANDS.put(CommandOptions.UNEQUIP.getCommand(), args -> new UnequipGearCommand(itemType(args[0])));
        COMMANDS.put(CommandOptions.USE_ITEM.getCommand(), args -> new UseItemCommand(itemType(args[0])));
        COMMANDS.put(CommandOptions.MOVE.getCommand(), args -> new MoveCommand(Direction.getDirection(args[0])));
    }

    public static Command createCommand(String input) {
        String[] commandSplit = input.split(" ", 2);

        String clientCommand = commandSplit[0].toLowerCase();
        CommandParser parser = COMMANDS.get(clientCommand);
        if (parser == null) {
            throw new IllegalArgumentException("Unknown command");
        }
        String[] args = Arrays.copyOfRange(commandSplit, 1, commandSplit.length);
        return parser.parse(args);

    }

    private static ItemType itemType(String itemName) {
        return ItemType.getByName(itemName);
    }
}
