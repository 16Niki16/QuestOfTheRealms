package sofia.sap.interview.project.game.dto.savegame.data;

public class GameData {
    private CharacterData character;
    private MapData map;
    private QuestsData quests;

    public CharacterData getCharacter() {
        return character;
    }

    public void setCharacter(CharacterData character) {
        this.character = character;
    }

    public MapData getMap() {
        return map;
    }

    public void setMap(MapData map) {
        this.map = map;
    }

    public QuestsData getQuests() {
        return quests;
    }

    public void setQuests(QuestsData quests) {
        this.quests = quests;
    }
}
