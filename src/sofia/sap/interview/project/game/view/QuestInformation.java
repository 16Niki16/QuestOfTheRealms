package sofia.sap.interview.project.game.view;

import sofia.sap.interview.project.game.quests.Quest;

import java.util.Set;

public record QuestInformation(Set<Quest> active, Set<Quest> completed) implements ViewInformation {
}
