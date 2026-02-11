import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.RunCommand;
import sofia.sap.interview.project.game.gameplay.Gameplay;
import sofia.sap.interview.project.game.map.directions.Direction;

public class Main {
    public static void main(String[] args) {
        Character dummy = new Character("niki", AllyCharacterType.MAGE);
        Gameplay game = new Gameplay(dummy);
        System.out.println(game.getPossibleDirections());
        GameContext context = new GameContext(game, dummy);
        Command command = new RunCommand(context, Direction.EAST);
        CommandResult result = command.execute();
        System.out.println(result.resultMessage());
    }
}