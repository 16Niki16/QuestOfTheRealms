package sofia.sap.interview.project.game.user;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;

public class User {
    private String username;
    private Character character;

    private User(String username, Character character) {
        this.username = username;
        this.character = character;
    }

    public static User loadUserWithCharacter(String username, Character character) {
        return new User(username, character);
    }

    public static User loadUserCreateCharacter(String username, String characterName, AllyCharacterType type) {
        return new User(username, new Character(characterName, type));
    }

    public void changeCharacter(String characterName, AllyCharacterType type) {
        this.character = new Character(characterName, type);
    }
}
