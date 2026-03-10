import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.CheckQuestsCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.DefendCommand;
import sofia.sap.interview.project.game.command.commands.PathsCommand;
import sofia.sap.interview.project.game.command.commands.EquipGearCommand;
import sofia.sap.interview.project.game.command.commands.HelpCommand;
import sofia.sap.interview.project.game.command.commands.LookCommand;
import sofia.sap.interview.project.game.command.commands.MoveCommand;
import sofia.sap.interview.project.game.command.commands.NewGameCommand;
import sofia.sap.interview.project.game.command.commands.OpenChestCommand;
import sofia.sap.interview.project.game.command.commands.UnequipGearCommand;
import sofia.sap.interview.project.game.command.commands.UseItemCommand;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.console.ConsoleRenderer;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.quests.FindIronKey;
import sofia.sap.interview.project.game.quests.KillGoblinKing;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.Reward;
import sofia.sap.interview.project.game.user.User;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user = User.createUser("Niki");
        Map<Quest, Reward> quests = Map.of(new KillGoblinKing(), Reward.BIG, new FindIronKey(), Reward.MEDIUM);
        NewGameCommand newGame = new NewGameCommand("kaisa", AllyCharacterType.MAGE);
        CommandResult result231 = newGame.execute(user);

        ConsoleRenderer renderer = new ConsoleRenderer();
        //possible directions
        Command command4 = new PathsCommand();
        CommandResult result4 = command4.execute(user);
        renderer.render(result4);
        //look
        Command command1 = new LookCommand();
        CommandResult result1 = command1.execute(user);
        renderer.render(result1);
        //open chest
        Command command69 = new OpenChestCommand();
        CommandResult result69 = command69.execute(user);
        renderer.render(result69);
        //move
        Command command = new MoveCommand(Direction.EAST);
        CommandResult result = command.execute(user);
        renderer.render(result);
        //help
        Command command2 = new HelpCommand();
        CommandResult result2 = command2.execute(user);
        renderer.render(result2);
        //quest information
        Command command3 = new CheckQuestsCommand();
        CommandResult result3 = command3.execute(user);
        renderer.render(result3);

        //equip gear
        Command command68 = new EquipGearCommand(ItemType.IRON_DAGGER);
        CommandResult result68 = command68.execute(user);
        renderer.render(result68);
        //unequip gear
        Command command67 = new UnequipGearCommand(ItemType.IRON_DAGGER);
        CommandResult result67 = command67.execute(user);
        renderer.render(result67);
        //use item
        Command command66 = new UseItemCommand(ItemType.HEALING_HERB);
        CommandResult result66 = command66.execute(user);
        renderer.render(result66);
        //look
        CommandResult result12 = command1.execute(user);
        renderer.render(result12);
        //attack
        Command command23 = new AttackCommand();
        CommandResult result33 = command23.execute(user);
        renderer.render(result33);
        //defend
        Command command32 = new DefendCommand();
        CommandResult result41 = command32.execute(user);
        renderer.render(result41);
        //attack(check mana not enough)
        CommandResult result5 = command23.execute(user);
        renderer.render(result5);
        CommandResult result6 = command23.execute(user);
        renderer.render(result6);
        CommandResult result7 = command23.execute(user);
        renderer.render(result7);
        CommandResult result8 = command23.execute(user);
        renderer.render(result8);
        CommandResult result9 = command23.execute(user);
        renderer.render(result9);
        CommandResult result10 = command23.execute(user);
        renderer.render(result10);
        //Direction choice
        Command command43 = new PathsCommand();
        CommandResult result0 = command43.execute(user);
        renderer.render(result0);
        //move
        Command command5 = new MoveCommand(Direction.NORTH);
        CommandResult result51 = command5.execute(user);
        renderer.render(result51);
    }
}