package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.events.GameEvent;

public class KillBoss extends QuestBase {
    private static final EnemyType BOSS = EnemyType.BOSS;

    public KillBoss() {
        super(Reward.GRAND);
    }

    @Override
    public String questDescription() {
        return "You need to find and kill the boss!";
    }

    @Override
    public void update(GameEvent event) {

    }
}
