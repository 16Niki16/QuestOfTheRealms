package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.view.QuestInformation;

import java.util.Set;

public class CheckQuestsCommand implements Command {
    private final GameSession context;

    public CheckQuestsCommand(GameSession context) {
        this.context = context;
    }

    @Override
    public CommandResult execute() {
        Set<Quest> active = this.context.log().getActiveQuests();
        Set<Quest> completed = this.context.log().getCompletedQuests();

        return new ViewResult(new QuestInformation(active, completed));
    }
}
