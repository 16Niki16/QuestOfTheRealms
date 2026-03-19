package sofia.sap.interview.project.game.console;

import sofia.sap.interview.project.game.command.CommandFactory;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.events.EventProcessor;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class CommandExecutor {
    private static final ConsoleRenderer RENDERER = new ConsoleRenderer();

    public static void executor(User user, String input) {
        Command command = CommandFactory.createCommand(input);
        List<CommandResult> results = command.execute(user);

        List<CommandResult> allResults = EventProcessor.process(user, results);
        RENDERER.render(allResults);
    }
}
