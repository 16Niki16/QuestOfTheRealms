package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.map.Coordinates;

public class MapData {

    private PlaygroundData playgroundData;
    private Coordinates coordinates;

    public PlaygroundData getPlaygroundData() {
        return playgroundData;
    }

    public void setPlaygroundData(PlaygroundData playgroundData) {
        this.playgroundData = playgroundData;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
