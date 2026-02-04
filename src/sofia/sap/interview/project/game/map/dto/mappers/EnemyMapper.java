package sofia.sap.interview.project.game.map.dto.mappers;

import sofia.sap.interview.project.game.characters.enemy.Enemy;

import java.util.Collections;
import java.util.List;

public class EnemyMapper {
    public static List<Enemy> map(List<String> enemies) {
        if (enemies == null || enemies.isEmpty()) {
            return Collections.emptyList();
        }

        return enemies.stream()
            .map(Enemy::createEnemy)
            .toList();
    }
}
