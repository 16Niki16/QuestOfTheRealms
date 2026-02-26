package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.enemy.Enemy;

public record KillEnemyEvent(Enemy enemy) implements GameEvent {
}
