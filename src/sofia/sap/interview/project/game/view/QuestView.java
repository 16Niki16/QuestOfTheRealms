package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.information.QuestInformation;
import sofia.sap.interview.project.game.quests.Quest;

import java.util.List;

public class QuestView implements ViewCommand<QuestInformation> {
    @Override
    public void render(QuestInformation information) {
        List<Quest> active = information.active();
        List<Quest> completed = information.completed();
        System.out.println("The active quests are:");

        for (Quest quest : active) {
            System.out.println(quest.questDescription());
        }
        System.out.println("The completed quests are:");

        for (Quest quest : completed) {
            System.out.println(quest.questDescription());
        }
    }
}
