import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.gameplay.Gameplay;

public class Main {
    public static void main(String[] args) {
        Character dummy = new Character("niki", AllyCharacterType.MAGE);
        Gameplay game = new Gameplay(dummy);
        System.out.println(game.getPossibleDirections());
    }
}