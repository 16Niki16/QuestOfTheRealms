package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.files.NewGame;
import sofia.sap.interview.project.game.map.Playground;

public class GameSessionCreator {
    public static GameSession newGame(String characterName, AllyCharacterType type) {
        Character character = new Character(characterName, type);
        Playground playground = NewGame.createPlayground();
        Gameplay gameplay = new Gameplay(playground);
        CombatService actions = new CombatService();
        return new GameSession(gameplay, character, actions);
    }
}
