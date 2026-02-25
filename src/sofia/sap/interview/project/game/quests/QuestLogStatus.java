package sofia.sap.interview.project.game.quests;

import java.util.Set;

public class QuestLogStatus {
    public static String parser(Set<Quest> completed, Set<Quest> active) {
        StringBuilder parse = new StringBuilder("Completed:\n");

        for (Quest quest : completed) {
            parse.append(quest.questDescription()).append("\n");
        }
        parse.append("Active:\n");

        for (Quest quest : active) {
            parse.append(quest.questDescription()).append("\n");
        }
        return parse.toString();
    }
}
