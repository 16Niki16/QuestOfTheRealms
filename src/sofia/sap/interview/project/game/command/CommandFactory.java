package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.DefendCommand;
import sofia.sap.interview.project.game.command.commands.RunCommand;
import sofia.sap.interview.project.game.command.commands.UseItemCommand;
import sofia.sap.interview.project.game.map.directions.Direction;

public class CommandFactory {
    /***
     * place to create the command, depends on client input??
     *
     */
    public static Command createCommand(String input, GameContext context) {
        String[] commandSplit = input.split(" ", 2);

        String command = commandSplit[0].toLowerCase();
        CombatOptions option = CombatOptions.getOption(command);
        return switch (option) {
            case ATTACK -> new AttackCommand(context);
            case DEFEND -> new DefendCommand(context);
            case USE_ITEM -> new UseItemCommand(context, commandSplit[1]);
            case RUN -> new RunCommand(context, Direction.EAST);
            case LOOK -> null;
            case MOVE -> null;
        };
    }
}
