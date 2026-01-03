package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.map.Playground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Gameplay {
    private Character character;
    private Playground playground;

    public Gameplay(Character character, Reader reader) {
        this.character = character;
        this.playground =;//creating map from file
    }

    private Playground createMapFromFile(Reader reader) {
        try (BufferedReader read = new BufferedReader(reader)) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
