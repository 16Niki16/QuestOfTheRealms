package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.GameData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

public class GameDataFactory {
    public static GameData save(GameSession session, QuestLog log) {
        GameData game = new GameData();
        game.setCharacter(CharacterDataFactory.create(session.character()));
        game.setMap(MapDataFactory.create(session.gameplay()));
        game.setQuests(QuestsDataFactory.create(log));
        return game;
    }
}
