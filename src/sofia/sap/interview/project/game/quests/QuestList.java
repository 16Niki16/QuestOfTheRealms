package sofia.sap.interview.project.game.quests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class QuestList {
    private static final Map<QuestType, Supplier<Quest>> QUESTS = new EnumMap<>(QuestType.class);

    static {
        QUESTS.put(QuestType.FIND_IRON_KEY, FindIronKey::new);
        QUESTS.put(QuestType.KILL_GOBLIN_KING, KillGoblinKing::new);

    }

    public static Set<Quest> createQuests() {
        List<Supplier<Quest>> quests = new ArrayList<>(QUESTS.values());
        Collections.shuffle(quests);

        int numberOfQuests = ThreadLocalRandom.current().nextInt(1, 3);
        
        return quests.stream()
                .limit(numberOfQuests)
                .map(Supplier::get)
                .collect(Collectors.toSet());
    }
}
