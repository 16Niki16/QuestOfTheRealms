package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;

public class KillGoblinKing extends QuestBase {
    private final EnemyType target;

    public KillGoblinKing(String message) {
        super(message);
        this.target = EnemyType.GOBLIN;
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof KillEnemyEvent e && e.getKilledEnemy().getType().equals(target)) {
            completeQuest();
        }
    }

}
