import sofia.sap.interview.project.game.GameController;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.CommandFactory;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.console.ConsoleRenderer;
import sofia.sap.interview.project.game.events.EventProcessor;
import sofia.sap.interview.project.game.files.SaveGame;
import sofia.sap.interview.project.game.user.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();
        User user = User.createUser("Niki");
        controller.addUser(user);
        user.createNewGame("kaisa", AllyCharacterType.MAGE);
        ConsoleRenderer renderer = new ConsoleRenderer();
        /*User user = User.createUser("Niki");
        user.loadGame();
        ConsoleRenderer renderer = new ConsoleRenderer();
        //possible directions
        Command command4 = new PathsCommand();
        List<CommandResult> result4 = command4.execute(user);
        renderer.render(result4);
        //look
        Command command1 = new LookCommand();
        List<CommandResult> result1 = command1.execute(user);
        renderer.render(result1);
        //open chest
        Command command69 = new OpenChestCommand();
        List<CommandResult> result69 = command69.execute(user);
        renderer.render(result69);
        //move
        Command command = new MoveCommand(Direction.EAST);
        List<CommandResult> result = command.execute(user);
        renderer.render(result);*/

        // User user = LoadGame.loadGame("Niki");
        /*
        //possible directions
        Command command4 = new PathsCommand();
        List<CommandResult> result4 = command4.execute(user);
        renderer.render(result4);
        //look
        Command command1 = new LookCommand();
        List<CommandResult> result1 = command1.execute(user);
        renderer.render(result1);
        //open chest
        Command command69 = new OpenChestCommand();
        List<CommandResult> result69 = command69.execute(user);
        renderer.render(result69);
        //move
        Command command = new MoveCommand(Direction.EAST);
        List<CommandResult> result = command.execute(user);
        renderer.render(result);
        //help
        Command command2 = new HelpCommand();
        List<CommandResult> result2 = command2.execute(user);
        renderer.render(result2);
        //quest information
        Command command3 = new CheckQuestsCommand();
        List<CommandResult> result3 = command3.execute(user);
        renderer.render(result3);

        //equip gear
        Command command68 = new EquipGearCommand(ItemType.IRON_DAGGER);
        List<CommandResult> result68 = command68.execute(user);
        renderer.render(result68);
        //unequip gear
        Command command67 = new UnequipGearCommand(ItemType.IRON_DAGGER);
        List<CommandResult> result67 = command67.execute(user);
        renderer.render(result67);
        //use item
        Command command66 = new UseItemCommand(ItemType.HEALING_HERB);
        List<CommandResult> result66 = command66.execute(user);
        renderer.render(result66);
        //look
        List<CommandResult> result12 = command1.execute(user);
        renderer.render(result12);
        //attack
        Command command23 = new AttackCommand();
        List<CommandResult> result33 = command23.execute(user);
        renderer.render(result33);
        //defend
        Command command32 = new DefendCommand();
        List<CommandResult> result41 = command32.execute(user);
        renderer.render(result41);
        //attack(check mana not enough)
        List<CommandResult> result5 = command23.execute(user);
        renderer.render(result5);
        List<CommandResult> result6 = command23.execute(user);
        renderer.render(result6);
        List<CommandResult> result7 = command23.execute(user);
        renderer.render(result7);
        List<CommandResult> result8 = command23.execute(user);
        renderer.render(result8);
        List<CommandResult> result9 = command23.execute(user);
        renderer.render(result9);
        List<CommandResult> result10 = command23.execute(user);
        renderer.render(result10);
        //Direction choice
        Command command43 = new PathsCommand();
        List<CommandResult> result0 = command43.execute(user);
        renderer.render(result0);*/
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i < 5) {
            String input = scan.nextLine();
            Command command = CommandFactory.createCommand(input);
            List<CommandResult> results = command.execute(user);
            EventProcessor.process(user, results);
            renderer.render(results);
            i++;
        }
        SaveGame.saveGame(user);
    }
}