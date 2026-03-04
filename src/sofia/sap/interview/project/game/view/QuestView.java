package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.information.QuestInformation;
import sofia.sap.interview.project.game.quests.Quest;

import java.util.Set;

public class QuestView implements StatelessCommandView<QuestInformation> {
    @Override
    public void render(QuestInformation information) {
        Set<Quest> active = information.active();
        Set<Quest> completed = information.completed();
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
