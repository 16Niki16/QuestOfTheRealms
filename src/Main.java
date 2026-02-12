import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.command.GameContext;
import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.DefendCommand;
import sofia.sap.interview.project.game.command.commands.DirectionChoiceCommand;
import sofia.sap.interview.project.game.command.commands.LookCommand;
import sofia.sap.interview.project.game.command.commands.MoveCommand;
import sofia.sap.interview.project.game.gameplay.Gameplay;
import sofia.sap.interview.project.game.map.directions.Direction;

public class Main {
    public static void main(String[] args) {
        Character dummy = new Character("niki", AllyCharacterType.MAGE);
        Gameplay game = new Gameplay(dummy);
        System.out.println(game.getPossibleDirections());
        GameContext context = new GameContext(game, dummy);
        //look
        Command command1 = new LookCommand(context);
        CommandResult result1 = command1.execute();
        System.out.println(result1.resultMessage());
        //run
        Command command = new MoveCommand(context, Direction.EAST);
        CommandResult result = command.execute();
        System.out.println(result.resultMessage());
        //look
        CommandResult result2 = command1.execute();
        System.out.println(result2.resultMessage());
        //attack
        /*Command command2 = new AttackCommand(context);
        CommandResult result3 = command2.execute();
        System.out.println(result3.resultMessage());
        //defend
        Command command3 = new DefendCommand(context);
        CommandResult result4 = command3.execute();
        System.out.println(result4.resultMessage());*/
        //Direction choice
        Command command4 = new DirectionChoiceCommand(context);
        CommandResult result0 = command4.execute();
        System.out.println(result0.resultMessage());
        //move
        Command command5 = new MoveCommand(context, Direction.NORTH);
        CommandResult result5 = command5.execute();
        System.out.println(result5.resultMessage());
    }
}