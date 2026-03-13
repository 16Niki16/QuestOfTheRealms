package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.ally.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterStatisticsData;

public class CharacterStatisticsDataFactory {
    public static CharacterStatisticsData create(CharacterStatistics statistics) {
        CharacterStatisticsData data = new CharacterStatisticsData();

        data.setHealth(statistics.getHealth());
        data.setMana(statistics.getMana());
        data.setAttackRange(statistics.getAttackRange());

        return data;
    }
}
