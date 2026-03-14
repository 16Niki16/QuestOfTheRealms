package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.MapData;
import sofia.sap.interview.project.game.gameplay.Gameplay;

public class MapDataFactory {
    public static MapData create(Gameplay gameplay) {
        MapData map = new MapData();

        map.setPlaygroundData(PlaygroundDataFactory.create(gameplay.getPlayground()));
        map.setCoordinates(gameplay.getPlayerCoordinates());

        return map;
    }
}
