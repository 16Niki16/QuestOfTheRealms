package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class EventProcessor {
    public static void process(User user, List<CommandResult> results) {

        for (CommandResult result : results) {

            if (result instanceof EventResult eventResult) {
                GameEvent event = eventResult.event();
                boolean questCompleted = user.handleEvent(event);

                if (event instanceof CharacterDiedEvent) {
                    user.endGame();
                }

                if (questCompleted) {
                    System.out.println("Quest completed!");
                }
            }
        }
    }
}
