package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.gameplay.Gameplay;

public class GameContext {
    private final Gameplay gameplay;
    private final Character character;

    public GameContext(Gameplay gameplay, Character character) {
        this.gameplay = gameplay;
        this.character = character;
    }

    public Gameplay getGameplay() {
        return this.gameplay;
    }

    public Character getCharacter() {
        return this.character;
    }
}
