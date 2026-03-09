package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.information.QuestInformation;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.user.User;

import java.util.Set;

public class CheckQuestsCommand implements Command {
    private final User user;

    public CheckQuestsCommand(User user) {
        this.user = user;
    }

    @Override
    public CommandResult execute() {
        Set<Quest> active = this.user.getLog().getActiveQuests();
        Set<Quest> completed = this.user.getLog().getCompletedQuests();

        return new ViewResult(new QuestInformation(active, completed));
    }
}
