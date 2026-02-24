package sofia.sap.interview.project.game.user;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.gameplay.Gameplay;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String username;
    private Set<Gameplay> gameplays;

    private User(String username, Set<Gameplay> gameplays) {
        this.username = username;
        this.gameplays = gameplays;
    }

    public static User loadUserWithCharacter(String username, Set<Gameplay> gameplays) {
        return new User(username, gameplays);
    }

    public static User createUser(String username) {
        return new User(username, new HashSet<>());
    }

    public void createCharacter(String characterName, AllyCharacterType type) {
        Character character = new Character(characterName, type);
    }
}
